package dev.tigr.mesh.impl.client.util;

import net.minecraft.client.util.Session;

/**
 * @author Tigermouthbear 1/10/22
 */
public class SessionMesh extends dev.tigr.mesh.api.util.Session<Session> {
    public SessionMesh(net.minecraft.client.util.Session value) {
        super(value);
    }

    @Override
    public String getSessionId() {
        return getMeshValue().getSessionId();
    }

    @Override
    public String getUuid() {
        return getMeshValue().getUuid();
    }

    @Override
    public String getUsername() {
        return getMeshValue().getUsername();
    }

    @Override
    public String getAccessToken() {
        return getMeshValue().getAccessToken();
    }

}
