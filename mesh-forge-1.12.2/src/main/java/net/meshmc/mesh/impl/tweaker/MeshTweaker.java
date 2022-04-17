package net.meshmc.mesh.impl.tweaker;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinTweaker;

import java.io.File;
import java.util.List;

/**
 * loads mesh mods, adds mixin configs, and other prelaunch stuff
 * @author Tigermouthbear 4/8/22
 *
 * NOTE: MINECRAFT DEVS ARE STUPID, WHY DO TWEAKERS ADD THEIR WHOLE PACKAGE TO CLASSLOADER EXCLUSION??!?!
 * i almost died trying to make this work
 */
public class MeshTweaker implements ITweaker {
    private final MixinTweaker mixinTweaker;
    {
        Object tweakClassesObject = Launch.blackboard.get("TweakClasses");
        if(tweakClassesObject instanceof List) {
            List<String> tweakClasses = (List<String>) tweakClassesObject;
            if(tweakClasses.contains("org.spongepowered.asm.launch.MixinTweaker")) mixinTweaker = null;
            else mixinTweaker = new MixinTweaker();
        } else mixinTweaker = null;
    }

    private File gameDir = null;

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.gameDir = gameDir;

        if(mixinTweaker != null) mixinTweaker.acceptOptions(args, gameDir, assetsDir, profile);
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        if(gameDir != null) {
            try {
                classLoader.findClass("net.meshmc.mesh.Mesh")
                    .getMethod("load", File.class, ClassLoader.class)
                    .invoke(null, gameDir, classLoader);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else throw new RuntimeException("Mesh failed to find game directory!");

        if(mixinTweaker != null) mixinTweaker.injectIntoClassLoader(classLoader);
    }

    @Override
    public String getLaunchTarget() {
        return mixinTweaker == null ? "net.minecraft.client.main.Main" : mixinTweaker.getLaunchTarget();
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}
