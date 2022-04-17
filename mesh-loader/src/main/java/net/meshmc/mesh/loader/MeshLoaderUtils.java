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

    static void load(ClassLoader classLoader, File... files) throws Exception {
        Method addURL;
        if(classLoader instanceof URLClassLoader) addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        else addURL = classLoader.getClass().getDeclaredMethod("addURL", URL.class);

        addURL.setAccessible(true);

        for(File file: files) {
            addURL.invoke(classLoader, file.toURI().toURL());
        }
    }
}
