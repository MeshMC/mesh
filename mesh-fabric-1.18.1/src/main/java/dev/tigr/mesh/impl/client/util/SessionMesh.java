package dev.tigr.mesh.impl.client.util;

import dev.tigr.mesh.api.util.ISession;
import net.minecraft.client.util.Session;

/**
 * Mesh API interface for minecraft Session util class
 *
 * @author Tigermouthbear 1/1/22
 */
public class SessionMesh implements ISession {
    private final Session session;

    public SessionMesh(Session session) {
        this.session = session;
    }

    @Override
    public String getSessionId() {
        return session.getSessionId();
    }

    @Override
    public String getUuid() {
        return session.getUuid();
    }

    @Override
    public String getUsername() {
        return session.getUsername();
    }

    @Override
    public String getAccessToken() {
        return session.getAccessToken();
    }
}
