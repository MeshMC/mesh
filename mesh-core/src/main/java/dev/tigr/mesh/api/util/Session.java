package dev.tigr.mesh.api.util;

import dev.tigr.mesh.api.AbstractMesh;

/**
 * Provides a mesh interface for minecraft's session
 * @author Tigermouthbear 1/10/22
 */
public abstract class Session<T> extends AbstractMesh<T> {
    public Session(T value) {
        super(value);
    }

    public abstract String getSessionId();

    public abstract String getUuid();

    public abstract String getUsername();

    public abstract String getAccessToken();
}
