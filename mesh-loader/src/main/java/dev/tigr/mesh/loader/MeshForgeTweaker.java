package dev.tigr.mesh.loader;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinTweaker;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author Tigermouthbear 1/23/22
 */
public class MeshForgeTweaker implements ITweaker {
    private static final Class<?> LAUNCH_CLASS;
    static {
        try {
            LAUNCH_CLASS = Class.forName("net.minecraft.launchwrapper.Launch");
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public MeshForgeTweaker() {
        ClassLoader classLoader = getClassLoader();
        String gameVersion = getGameVersion();
        if(classLoader == null || gameVersion == null || !isVersionSupported(classLoader, gameVersion)) return;

        try {
            // load the forge version on both class loaders
            File meshCore = MeshLoader.unpack("mesh-core.jar", getClass().getClassLoader());
            File mesh = MeshLoader.unpack("forge", gameVersion, getClass().getClassLoader());
            MeshLoader.load(getClass().getClassLoader(), meshCore, mesh);
            MeshLoader.load(classLoader, meshCore, mesh);

            // add mixin tweaker to the tweaker list
            Map<String,Object> blackboard = (Map<String,Object>) LAUNCH_CLASS.getField("blackboard").get(null);
            List<ITweaker> tweakers = (List<ITweaker>) blackboard.get("Tweaks");
            tweakers.add(new MixinTweaker());

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
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }

    private static ClassLoader getClassLoader() {
        try {
            return (ClassLoader) LAUNCH_CLASS.getDeclaredField("classLoader").get(null);
        } catch(Exception ignored) {
        }
        return null;
    }

    private static boolean isVersionSupported(ClassLoader classLoader, String gameVersion) {
        return classLoader.getResource("mesh-forge-" + gameVersion + ".jar") != null;
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
