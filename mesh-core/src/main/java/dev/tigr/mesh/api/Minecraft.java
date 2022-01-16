package dev.tigr.mesh.api;

import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.api.util.Session;

/**
 * Provides a mesh interface for the main minecraft class
 * @author Tigermouthbear 1/10/22
 */
public abstract class Minecraft<T> extends AbstractMesh<T> {
    public Minecraft(T value) {
        super(value);
    }

    public abstract Profiler<?> getProfiler();

    public abstract TextRenderer<?> getTextRenderer();

    public abstract Session<?> getSession();
    public abstract void setSession(Session<?> session);
}
