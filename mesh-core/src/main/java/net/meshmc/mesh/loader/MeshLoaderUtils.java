package net.meshmc.mesh.loader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * @author Tigermouthbear 1/23/22
 */
public class MeshLoaderUtils {
    static File unpack(String loader, String version, ClassLoader classLoader) throws Exception {
        return unpack("mesh-" + loader + "-" + version + ".jar", classLoader);
    }

    static File unpack(String path, ClassLoader classLoader) throws Exception {
        // create temp file of jar to load from classpath
        File tempFile = File.createTempFile("mesh", ".jar");
        tempFile.deleteOnExit();

        // read jar from resources
        int read;
        byte[] buffer = new byte[64];
        InputStream is = Objects.requireNonNull(classLoader.getResourceAsStream(path));
        FileOutputStream fos = new FileOutputStream(tempFile);
        while((read = is.read(buffer)) != -1) fos.write(buffer, 0, read);
        fos.close();
        is.close();
        return tempFile;
    }

    public static void load(ClassLoader classLoader, File... files) throws Exception {
        for(File file: files) {
            load(classLoader, file);
        }
    }

    private static Method ADDURL_URLCLASSLOADER = null;
    private static Method ADDURL_KNOTCLASSLOADER = null;
    public static void load(ClassLoader classLoader, File file) throws Exception {
        if(classLoader instanceof URLClassLoader) {
            if(ADDURL_URLCLASSLOADER == null) {
                ADDURL_URLCLASSLOADER = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                ADDURL_URLCLASSLOADER.setAccessible(true);
            }
            ADDURL_URLCLASSLOADER.invoke(classLoader, file.toURI().toURL());
        }
        else {
            if(ADDURL_KNOTCLASSLOADER == null) {
                ADDURL_KNOTCLASSLOADER = classLoader.getClass().getDeclaredMethod("addURL", URL.class);
                ADDURL_KNOTCLASSLOADER.setAccessible(true);
            }
            ADDURL_KNOTCLASSLOADER.invoke(classLoader, file.toURI().toURL());
        }
    }

    public static ClassLoader getFabricClassLoader() {
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

    public static ClassLoader getLaunchClassLoader() {
        try {
            return (ClassLoader) Class.forName("net.minecraft.launchwrapper.Launch")
                    .getDeclaredField("classLoader").get(null);
        } catch(Exception ignored) {
        }
        return null;
    }
}
