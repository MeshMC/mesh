package dev.tigr.mesh;

import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.impl.client.util.SessionMesh;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public Session<?> createSession(String username, String uuid, String accessToken, String type) {
        return new SessionMesh(new net.minecraft.client.util.Session(username, uuid, accessToken, null, null, net.minecraft.client.util.Session.AccountType.byName(type)));
    }
}
