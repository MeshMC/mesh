package net.meshmc.mesh.loader;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Tigermouthbear 1/23/22
 */
public class MeshForgeTweaker implements ITweaker {
    private ITweaker meshTweaker = null;

    public MeshForgeTweaker() {
        ClassLoader classLoader = getLaunchClassLoader();
        String gameVersion = getGameVersion();
        if(classLoader == null || gameVersion == null || !isVersionSupported(classLoader, gameVersion)) return;

        try {
            // load core and forge impl into launch classLoader
            File mesh = MeshLoaderUtils.unpack("forge", gameVersion, getClass().getClassLoader());
            MeshLoaderUtils.load(
                classLoader,
                MeshLoaderUtils.unpack("mesh-core.jar", getClass().getClassLoader()),
                mesh
            );

            // also load forge impl into current classloader to allow mixins to work
            MeshLoaderUtils.load(getClass().getClassLoader(), mesh);

            // create a new mesh tweaker for the version
            meshTweaker = (ITweaker) ((Class<?>) classLoader.getClass().getMethod("findClass", String.class)
                    .invoke(classLoader, "net.meshmc.mesh.impl.tweaker.MeshTweaker")).getConstructor().newInstance();

            // remove mesh from the libraries list so that it will get parsed as a mod
            Class<?> coreModManagerClass = Class.forName("net.minecraftforge.fml.relauncher.CoreModManager");
            Field candidateModFilesField = coreModManagerClass.getDeclaredField("candidateModFiles");
            candidateModFilesField.setAccessible(true);
            List<String> candidateModFiles = (List<String>) candidateModFilesField.get(null);
            candidateModFiles.remove(mesh.getName());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        if(meshTweaker != null) meshTweaker.acceptOptions(args, gameDir, assetsDir, profile);
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        if(meshTweaker != null) meshTweaker.injectIntoClassLoader(classLoader);
    }

    @Override
    public String getLaunchTarget() {
        return meshTweaker != null ? meshTweaker.getLaunchTarget() : "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }

    private static boolean isVersionSupported(ClassLoader classLoader, String gameVersion) {
        return classLoader.getResource("mesh-forge-" + gameVersion + ".jar") != null;
    }

    private static ClassLoader getLaunchClassLoader() {
        try {
            return (ClassLoader) Class.forName("net.minecraft.launchwrapper.Launch")
                    .getDeclaredField("classLoader").get(null);
        } catch(Exception ignored) {
        }
        return null;
    }

    private static String getGameVersion() {
        String version = null;

        // 1.7 - 1.12.2
        try {
            version = (String) Class.forName("net.minecraftforge.common.ForgeVersion").getField("mcVersion").get(null);
        } catch(Exception ignored) {
        }

        // 1.13+
        try {
            version = (String) Class.forName("net.minecraftforge.versions.forge.ForgeVersion").getMethod("getVersion").invoke(null);
        } catch(Exception ignored) {
        }

        return version;
    }
}
