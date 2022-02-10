package dev.tigr.mesh.impl.mixininterface.client;

import dev.tigr.mesh.MeshStatics;

/**
 * Provides a mesh interface for minecraft's session
 * @author Tigermouthbear 1/10/22
 */
public interface Session {
    static Session create(String username, String uuid, String accessToken, String type) {
        return MeshStatics.createSession(username, uuid, accessToken, type);
    }

    String getSessionId();
    String getUuid();
    String getUsername();
    String getAccessToken();
}
