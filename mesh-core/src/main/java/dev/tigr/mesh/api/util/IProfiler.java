package dev.tigr.mesh.api.util;

public interface IProfiler {
    void pushSection(String name);

    void popSection();
}
