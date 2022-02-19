package dev.tigr.mesh.loader;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * @author Tigermouthbear 1/23/22
 */
public class MeshLoader {
    public static File unpack(String loader, String version, ClassLoader classLoader) throws Exception {
        return unpack("mesh-" + loader + "-" + version + ".jar", classLoader);
    }

    public static File unpack(String path, ClassLoader classLoader) throws Exception {
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
}
