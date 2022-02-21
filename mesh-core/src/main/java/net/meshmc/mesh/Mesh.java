package net.meshmc.mesh;

import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.event.MeshEventManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The main Mesh class. This manages all APIs and version specific procedures.
 * When making an interface for a new minecraft version, it must provide a class
 * (net.meshmc.mesh.impl.MeshImpl) in the classpath to be loaded as the implementation.
 * The constructor for this implementation must have no args because it is loaded
 * at runtime.
 *
 * @author Tigermouthbear 1/1/22
 */
public abstract class Mesh {
    protected static final Logger MESH_LOGGER = LogManager.getLogger("Mesh");

    /**
     * The current implementation of Mesh, this is loaded from
     * net.meshmc.mesh.impl.MeshImpl. If the class is not present,
     * a runtime exception is thrown
     */
    private static Mesh INSTANCE = null;

    /**
     * Enum type for minecraft mods loader, impls must specify this so
     * that users can check what loader minecraft is using
     */
    public enum LoaderType { FORGE, FABRIC }

    /**
     * Marks the main class/entry point of a Mesh mod and other
     * information about the mod: modid(unique name), version, and description
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Mod {
        /**
         * @return the modid(unique identifier) of the represented Mesh mod
         */
        String modid();

        /**
         * @return the version of the represented Mesh mod
         */
        String version();

        /**
         * @return the name of the represented Mesh mod
         */
        String name();

        /**
         * @return the description of the represented Mesh mod
         */
        String description() default "";
    }

    /**
     * Marks the method to be called from mesh on initialization
     * This should be used by mods for initialization so that if the loading stage of mesh mods ever change,
     * the initialization point will stay the same
     */
    public interface Initializer {
        void init();
    }

    private final LoaderType loaderType;
    private final String loaderVersion;

    // The event manager for mesh, all game, render, and client events are posted through this
    private final EventManager eventManager = new MeshEventManager(this);

    // List of all Mesh mods that have been initialized
    private final List<Mod> mods = new ArrayList<>();

    // Whether Mesh has been initialized, used to make sure it isn't initialized more than once in initializeMods()
    private boolean initialized = false;

    /**
     * Creates a new implementation of the Mesh interface. This should only
     * be called by the Mesh implementation sub-classes.
     * @param loaderType The loader that the implementation is running on.
     * @param loaderVersion The version of the loader that the implementation is running.
     */
    public Mesh(LoaderType loaderType, String loaderVersion) {
        this.loaderType = loaderType;
        this.loaderVersion = loaderVersion;
    }

    public static void initialize() {
        if(INSTANCE != null) return;
        try {
            INSTANCE = (Mesh) Class.forName("net.meshmc.mesh.impl.MeshImpl").getConstructor().newInstance();
        } catch(ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Mesh failed to find implementation in classpath!");
        }
        INSTANCE.initializeMods();
    }

    /**
     * Scans for {@link Mod} annotations on classes, creates a new instance of those mods, and calls the init() method in those mods.
     * Should be run by every mesh implementation when appropriate
     */
    private void initializeMods() {
        if(initialized) return;

        long start = System.currentTimeMillis();

        // this is a tiny bit slow, but this is a really easy and flexible way to do it
        // with exclusions it is waaaay faster than without
        Reflections reflections = new Reflections(new ConfigurationBuilder()
        .setUrls(ClasspathHelper.forClassLoader())
        .setScanners(Scanners.TypesAnnotated)
        .filterInputsBy(new FilterBuilder()
            .excludePackage("kotlin")
            .excludePackage("kotlinx")
            .excludePackage("java")
            .excludePackage("javax")
            .excludePackage("javassist")
            .excludePackage("dev.tigr.simpleevents")
            .excludePackage("net.meshmc.mesh")
            .excludePackage("org.jetbrains")
            .excludePackage("org.intellij")
            .excludePackage("org.reflections")
            .excludePackage("org.slf4j")
            .excludePackage("net.jodah.typetools")
            .excludePackage("org.spongepowered")
            .excludePackage("net.minecraft")
            .excludePackage("net.minecraftforge")
            .excludePackage("net.fabricmc")
            .excludePackage("com.mojang")
            .excludePackage("com.google")
            .excludePackage("org.apache")
            .excludePackage("paulscode")
            .excludePackage("org.lwjgl")
            .excludePackage("com.sun")
            .excludePackage("net.java")
            .excludePackage("net.sf")
            .excludePackage("org.objectweb")
            .excludePackage("scala")
            .excludePackage("org.jline")
            .excludePackage("org.codehaus")
            .excludePackage("it.unimi")
            .excludePackage("io.netty")
            .excludePackage("com.typesafe")
            .excludePackage("com.ibm")
            .excludePackage("ca.weblite")
            .excludePackage("oshi")
        ));
        reflections.getTypesAnnotatedWith(Mod.class).forEach((clazz) -> {
            Mod mod = clazz.getDeclaredAnnotation(Mod.class);
            if(mod != null) {
                try {
                    Object modObject = clazz.getConstructor().newInstance();
                    if(modObject instanceof Initializer) ((Initializer) modObject).init();
                } catch(NoSuchMethodException | InstantiationException |
                        IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Mesh failed to initialize mod named '" + mod.modid() + "'!");
                }
                mods.add(mod);
            }
        });

        MESH_LOGGER.info("Mesh for {} {} loaded {} mods in {} milliseconds!",
                loaderType.name().toLowerCase(), loaderVersion, mods.size(), System.currentTimeMillis() - start);

        initialized = true;
    }

    /**
     * Gets the minecraft mod loader Mesh is running on.
     * @return {@link LoaderType} of the minecraft process Mesh is running on.
     */
    public LoaderType getLoaderType() {
        return loaderType;
    }

    /**
     * Gets the version of the mod load that Mesh is running on.
     * @return A string representation of the current loader version.
     */
    public String getLoaderVersion() {
        return loaderVersion;
    }

    /**
     * Gets the event manager for the Mesh interface
     * @return {@link EventManager} that mesh is using to post game events
     */
    public EventManager getEventManager() {
        return eventManager;
    }

    /**
     * Gets a list of {@link Mod}s running under Mesh
     * @return The list of running Mesh {@link Mod}s
     */
    public List<Mod> getMods() {
        return mods;
    }

    /**
     * Gets the Mesh interface for Minecraft's main instance
     * @return The current {@link Minecraft} instance
     */
    public abstract Minecraft getMinecraft();

    /**
     * Gets the Mesh interface for rendering
     * @return A {@link Renderer} for rendering
     */
    public abstract Renderer getRenderer();

    /**
     * Gets the current implementation of Mesh
     * @return The implementation fo Mesh minecraft is using
     */
    public static Mesh getMesh() {
        return INSTANCE;
    }
}
