package dev.tigr.mesh.api.util;

import dev.tigr.mesh.api.AbstractMesh;

/**
 * Provides a mesh interface for minecraft's profiler
 * @author Makrennel & Tigermouthbear 1/10/22
 */
public abstract class Profiler<T> extends AbstractMesh<T> {
    public Profiler(T value) {
        super(value);
    }

    public abstract void pushSection(String name);

    public abstract void popSection();
}
