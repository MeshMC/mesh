package net.meshmc.mesh;

import com.google.gson.Gson;
import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.Utilities;
import net.meshmc.mesh.event.MeshEventManager;
import net.meshmc.mesh.loader.MeshLoaderUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public static void load() {
        if(INSTANCE != null) return;
        try {
            INSTANCE = (Mesh) Class.forName("net.meshmc.mesh.impl.MeshImpl").getConstructor().newInstance();
        } catch(ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Mesh failed to find implementation in classpath!");
        }

        long start = System.currentTimeMillis();

        INSTANCE.loadMods();
        INSTANCE.loaded = true;

        MESH_LOGGER.info("Mesh for {} {} loaded {} mods in {} milliseconds!",
                INSTANCE.loaderType.name().toLowerCase(), INSTANCE.loaderVersion,
                INSTANCE.mods.size(), System.currentTimeMillis() - start);
    }

    /**
     * Scans for mesh mods in the classpath adds them to the mod list
     * Should be run by every mesh implementation when appropriate
     */
    private void loadMods() {
        if(loaded) return;

        // find mods folder
        File minecraftFolder = getRunDirectory();
        File modFolder = minecraftFolder.isDirectory() ? new File(minecraftFolder, "mods") : null;
        if(modFolder == null || !modFolder.isDirectory()) return;

        // find mesh folder
        File meshFolder = new File(modFolder, "mesh");
        if(!meshFolder.isDirectory()) return;

        // find all mod files (.jar)s
        File[] modFiles = meshFolder.listFiles(file -> file.getName().endsWith(".jar"));
        if(modFiles == null || modFiles.length == 0) return;

        // load mesh mods into classpath
        try {
            if(loaderType == LoaderType.FABRIC) MeshLoaderUtils.load(MeshLoaderUtils.getFabricClassLoader(), modFiles);
            else MeshLoaderUtils.load(MeshLoaderUtils.getLaunchClassLoader(), modFiles);
        } catch(Exception e) {
            e.printStackTrace();
        }

        // find mesh mod jsons
        Gson gson = new Gson();
        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forClassLoader())
            .setScanners(Scanners.Resources)
        );
        //reflections.getAll(Scanners.Resources).forEach(MESH_LOGGER::info);
        reflections.getResources(".*\\.mesh\\.json").forEach((resource) -> {
            MESH_LOGGER.info("FOUND " + resource);
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
        MESH_LOGGER.info("END FIND");
    }

    // TODO: LOAD MIXINS DURING LOADMODS

    public static void initialize() {
        if(INSTANCE == null || !INSTANCE.loaded) {
            throw new RuntimeException("Mesh tried to initialize mods before loading them!");
        }

        INSTANCE.getEventManager().register(INSTANCE.getUtilities());

        for(Mod mod: INSTANCE.mods) {
            INSTANCE.initialize(mod);
        }
    }

    // call the initializers for each loaded mod
    private void initialize(Mod mod) {
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
     * Gets the .minecraft folder of the current running game
     * @return {@link File}
     */
    public abstract File getRunDirectory();

    /**
     * Gets the current implementation of Mesh
     * @return The implementation fo Mesh minecraft is using
     */
    public static Mesh getMesh() {
        return INSTANCE;
    }
}
