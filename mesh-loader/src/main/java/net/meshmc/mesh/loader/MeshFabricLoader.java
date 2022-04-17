package net.meshmc.mesh.loader;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import org.spongepowered.asm.mixin.Mixins;

/**
 * @author Tigermouthbear 1/23/22
 */
public class MeshFabricLoader implements ModInitializer, PreLaunchEntrypoint {
    private static Object meshImpl = null;

    @Override
    public void onPreLaunch() {
        ClassLoader classLoader = getClassLoader();
        String gameVersion = getGameVersion();
        if(classLoader == null || gameVersion == null || !isVersionSupported(classLoader, gameVersion)) return;

        try {
            MeshLoaderUtils.load(
                classLoader,
                MeshLoaderUtils.unpack("mesh-core.jar", classLoader),
                MeshLoaderUtils.unpack("fabric", gameVersion, classLoader)
            );

            // add mixins
            Mixins.addConfiguration("mesh.mixins.json");

            // call preLaunch for impl
            meshImpl = Class.forName("net.meshmc.mesh.impl.MeshImpl").getConstructor().newInstance();
            meshImpl.getClass().getMethod("onPreLaunch").invoke(meshImpl);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onInitialize() {
        if(meshImpl == null) {
            throw new RuntimeException("Mesh loader failed to find implementation to initialize!");
        }

        try {
            // initialize the implementation
            meshImpl.getClass().getMethod("onInitialize").invoke(meshImpl);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isVersionSupported(ClassLoader classLoader, String gameVersion) {
        return classLoader.getResource("mesh-fabric-" + gameVersion + ".jar") != null;
    }

    private static ClassLoader getClassLoader() {
        // loader v0.12.x
        Class<?> targetClass = null;
        try {
            targetClass = Class.forName("net.fabricmc.loader.impl.launch.FabricLauncherBase");
        } catch(Exception ignored) {
            // loader v0.11.x
            try {
                targetClass = Class.forName("net.fabricmc.loader.launch.common.FabricLauncherBase");
            } catch(Exception ignored2) {
            }
        }

        if(targetClass != null) {
            try {
                Object launcher = targetClass.getMethod("getLauncher").invoke(null);
                return (ClassLoader) launcher.getClass().getMethod("getTargetClassLoader").invoke(launcher);
            } catch(Exception ignored) {
            }
        }
        return null;
    }

    private static String getGameVersion() {
        // loader v0.12.x
        Class<?> targetClass = null;
        try {
            targetClass = Class.forName("net.fabricmc.loader.impl.FabricLoaderImpl");
        } catch(Exception ignored) {
        }
        if(targetClass != null) {
            return FabricLoaderImpl.INSTANCE.getGameProvider().getNormalizedGameVersion();
        }

        // loader v0.11.x
        try {
            targetClass = Class.forName("net.fabricmc.loader.api.FabricLoader");
        } catch(Exception ignored) {
        }
        if(targetClass != null) {
            try {
                return (String) Class.forName("net.fabricmc.loader.game.GameProvider").getMethod("getNormalizedGameVersion")
                .invoke(Class.forName("net.fabricmc.loader.FabricLoader").getMethod("getGameProvider")
                .invoke(targetClass.getMethod("getInstance").invoke(null)));
            } catch(Exception ignored) {
            }
        }

        return null;
    }
}
