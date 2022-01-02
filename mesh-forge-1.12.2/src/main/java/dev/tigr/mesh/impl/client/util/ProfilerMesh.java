package dev.tigr.mesh.impl.client.util;

import dev.tigr.mesh.api.util.IProfiler;
import net.minecraft.profiler.Profiler;

public class ProfilerMesh implements IProfiler {
    private final Profiler profiler;

    public ProfilerMesh(Profiler profiler) {
        this.profiler = profiler;
    }

    @Override
    public void pushSection(String name) {
        profiler.startSection(name);
    }

    @Override
    public void popSection() {
        profiler.endSection();
    }
}
