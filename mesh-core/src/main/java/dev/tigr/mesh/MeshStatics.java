package dev.tigr.mesh;

import dev.tigr.mesh.api.util.Session;

/**
 * This file holds static minecraft methods and constructors for mesh.
 * The class is implemented by every mesh impl and should have version specific code in it
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public Session<?> createSession(String username, String uuid, String accessToken, String type) {
        throw new RuntimeException();
    }
}
