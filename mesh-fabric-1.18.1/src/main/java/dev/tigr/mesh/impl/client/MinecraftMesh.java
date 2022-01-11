package dev.tigr.mesh.impl.client;

import dev.tigr.mesh.api.Minecraft;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.impl.client.util.ProfilerMesh;
import dev.tigr.mesh.impl.client.util.SessionMesh;
import dev.tigr.mesh.impl.mixin.accessors.MinecraftClientAccessor;
import net.minecraft.client.MinecraftClient;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MinecraftMesh extends Minecraft<MinecraftClient> {
    private final Profiler<?> profiler = new ProfilerMesh(getMeshValue().getProfiler());
    private Session<?> session = new SessionMesh(getMeshValue().getSession());

    public MinecraftMesh(MinecraftClient value) {
        super(value);
    }

    @Override
    public Profiler<?> getProfiler() {
        return profiler;
    }

    @Override
    public Session<?> getSession() {
        return session;
    }

    @Override
    public void setSession(Session<?> session) {
        this.session = session;
        ((MinecraftClientAccessor) getMeshValue()).setSession((net.minecraft.client.util.Session) session.getMeshValue());
    }
}
