package dev.tigr.mesh.impl.client.util;

import dev.tigr.mesh.api.util.Profiler;

/**
 * @author Tigermouthbear 1/10/22
 */
public class ProfilerMesh extends Profiler<net.minecraft.util.profiler.Profiler> {
    public ProfilerMesh(net.minecraft.util.profiler.Profiler value) {
        super(value);
    }

    @Override
    public void pushSection(String name) {
        getMeshValue().push(name);
    }

    @Override
    public void popSection() {
        getMeshValue().pop();
    }
}
