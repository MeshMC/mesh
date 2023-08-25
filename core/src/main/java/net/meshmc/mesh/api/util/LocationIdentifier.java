package net.meshmc.mesh.api.util;

import net.meshmc.mesh.MeshStatics;

/**
 * represents an asset/resource in the jar/archive
 * @author  Tigermouthbear  1/10/22
 *          Makrennel       3/13/22
 */
public interface LocationIdentifier {
    static LocationIdentifier create(String namespace, String path) {
        return MeshStatics.createLocationIdentifier(namespace, path);
    }

    static LocationIdentifier create(String path) {
        return MeshStatics.createLocationIdentifier(path);
    }

    String getNamespace();

    String getPath();

    String toString();

    default String getFullPath() {
        return "/assets/" + getNamespace() + "/" + getPath();
    }

    boolean equals(Object object);

    int hashCode();
}