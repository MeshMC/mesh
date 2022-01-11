package dev.tigr.mesh.impl.client.util;

import net.minecraft.util.Session;

/**
 * @author Tigermouthbear 1/10/22
 */
public class SessionMesh extends dev.tigr.mesh.api.util.Session<Session> {
    public SessionMesh(net.minecraft.util.Session session) {
        super(session);
    }

    @Override
    public String getSessionId() {
        return getMeshValue().getSessionID();
    }

    @Override
    public String getUuid() {
        return getMeshValue().getPlayerID();
    }

    @Override
    public String getUsername() {
        return getMeshValue().getUsername();
    }

    @Override
    public String getAccessToken() {
        return getMeshValue().getToken();
    }
}
