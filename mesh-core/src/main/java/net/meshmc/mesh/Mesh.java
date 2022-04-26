package net.meshmc.mesh;

import com.google.gson.Gson;
import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.Utilities;
import net.meshmc.mesh.event.MeshEventManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
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
    private static final Mesh INSTANCE;
    static {
        try {
            INSTANCE = (Mesh) Class.forName("net.meshmc.mesh.impl.MeshImpl").getConstructor().newInstance();
        } catch(Exception e) {
            throw new RuntimeException("Mesh failed to find implementation in classpath!");
        }
    }

    /**
     * Enum type for minecraft mods loader, impls must specify this so
     * that users can check what loader minecraft is using
     */
    public enum LoaderType { FORGE, FABRIC }

    public static class Mod {
        /**
         * the modid(unique identifier) of the represented Mesh mod
         */
        private String id;

        /**
         * the version of the represented Mesh mod
         */
        private String version;

        /**
         * the name of the represented Mesh mod
         */
        private String name;

        /**
         * the description of the represented Mesh mod
         */
        private String description;

        /**
         * a list of the authors of the mod
         */
        private String[] authors;

        /**
         * the website of the mod
         */
        private String website;

        /**
         * a list of {@link Initializer}s to be called on startup
         */
        private String[] initializers;

        public String getId() {
            return id;
        }

        public String getVersion() {
            return version;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String[] getAuthors() {
            return authors;
        }

        public String getWebsite() {
            return website;
        }
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

    // Whether Mesh has loaded all its mods, check in loadMods()
    private boolean loaded = false;
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

    /**
     * Loads mesh mods into the classpath from .minecraft/mods/mesh and adds them to the mods list
     * @param minecraftFolder minecraft's game directory
     * @param classLoader the classloader to load into
     */
    public static void load(File minecraftFolder, ClassLoader classLoader) {
        long start = System.currentTimeMillis();

        INSTANCE.loadMods(minecraftFolder, classLoader);

        MESH_LOGGER.info("Mesh for {} {} loaded {} mods in {} milliseconds!",
                INSTANCE.loaderType.name().toLowerCase(), INSTANCE.loaderVersion,
                INSTANCE.mods.size(), System.currentTimeMillis() - start);
    }

    /**
     * Scans for mesh mods in the classpath adds them to the mod list
     */
    private void loadMods(File minecraftFolder, ClassLoader classLoader) {
        if(loaded) return;

        // find mods folder
        File modFolder = minecraftFolder.isDirectory() ? new File(minecraftFolder, "mods") : null;

        // find mesh folder
        File meshFolder = minecraftFolder.isDirectory() ? new File(minecraftFolder, "mesh") : null;

        // find mesh folder in mods
        File modMeshFolder = modFolder != null && modFolder.isDirectory() ? new File(modFolder, "mesh") : null;

        if((meshFolder == null || !meshFolder.isDirectory())
                && (modFolder == null || !modFolder.isDirectory())
                && (modMeshFolder == null || !modMeshFolder.isDirectory())
        ) {
            loaded = true;
            return;
        }

        // find all mod files (.jar)s
        File[] fromMesh = null, fromMods = null, fromModsMesh = null;

        if(meshFolder != null && meshFolder.isDirectory())
            fromMesh = meshFolder.listFiles(file -> file.getName().endsWith(".jar"));

        if(modFolder != null && modFolder.isDirectory())
            fromMods = modFolder.listFiles(file -> file.getName().endsWith(".jar"));

        if(modMeshFolder != null && modMeshFolder.isDirectory())
            fromModsMesh = modMeshFolder.listFiles(file -> file.getName().endsWith(".jar"));

        if((fromMesh == null || fromMesh.length == 0)
                && (fromMods == null || fromMods.length == 0)
                && (fromModsMesh == null || fromModsMesh.length == 0)
        ) {
            loaded = true;
            return;
        }

        // load mesh mods into classpath
        try {
            Method addURL;

            try { // loader v0.14.x
                addURL = classLoader.getClass().getDeclaredMethod("addUrlFwd", URL.class);
            } catch(Exception ignored) { // loader pre v0.14.x
                if(classLoader instanceof URLClassLoader) addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                else addURL = classLoader.getClass().getDeclaredMethod("addURL", URL.class);
            }

            addURL.setAccessible(true);

            if(fromMesh != null && fromMesh.length != 0)
                for(File modFile: fromMesh)
                    addURL.invoke(classLoader, modFile.toURI().toURL());

            if(fromMods != null && fromMods.length != 0)
                for(File modFile: fromMods)
                    addURL.invoke(classLoader, modFile.toURI().toURL());

            if(fromModsMesh != null && fromModsMesh.length != 0)
                for(File modFile: fromModsMesh)
                    addURL.invoke(classLoader, modFile.toURI().toURL());

        } catch(Exception e) {
            e.printStackTrace();
        }

        // find mesh mod jsons
        Gson gson = new Gson();
        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forClassLoader())
            .setScanners(Scanners.Resources)
        );
        reflections.getResources(".*\\.mesh\\.json").forEach((resource) -> {
            InputStream is = ClasspathHelper.contextClassLoader().getResourceAsStream(resource);
            if(is == null) is = ClasspathHelper.staticClassLoader().getResourceAsStream(resource);
            if(is != null) {
                try {
                    mods.add(gson.fromJson(new InputStreamReader(is), Mod.class));
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        loaded = true;
    }

    // TODO: LOAD MIXINS DURING LOADMODS

    /**
     * Calls the initialization method for all mesh mods, and mesh utilities
     */
    public static void init() {
        if(!INSTANCE.loaded)
            throw new RuntimeException("Mesh tried to initialize mods before loading them!");

        long start = System.currentTimeMillis();

        INSTANCE.initMods();

        MESH_LOGGER.info("Mesh for {} {} initialized {} mods in {} milliseconds!",
                INSTANCE.loaderType.name().toLowerCase(), INSTANCE.loaderVersion,
                INSTANCE.mods.size(), System.currentTimeMillis() - start);

    }

    // call the initializers for each loaded mod
    private void initMods() {
        if(initialized) return;

        for(Mod mod: mods) {
            for(String className: mod.initializers) {
                Object initializer;
                try {
                    initializer = Class.forName(className).getConstructor().newInstance();
                } catch(Exception e) {
                    throw new RuntimeException("Mesh failed to create initializer instance " + className);
                }

                if(initializer instanceof Initializer) ((Initializer) initializer).init();
                else throw new RuntimeException("Mesh failed to call initializer " + className + " in mod " + mod.id);
            }
        }

        eventManager.register(INSTANCE.getUtilities());

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
     * Gets the Mesh Utility interface
     * @return {@link Utilities}
     */
    public abstract Utilities getUtilities();

    /**
     * Gets the current implementation of Mesh
     * @return The implementation fo Mesh minecraft is using
     */
    public static Mesh getMesh() {
        return INSTANCE;
    }
}
