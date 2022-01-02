package dev.tigr.mesh.impl.client;

import dev.tigr.mesh.api.IMinecraft;
import dev.tigr.mesh.api.util.IProfiler;
import dev.tigr.mesh.api.util.ISession;
import dev.tigr.mesh.impl.client.util.ProfilerMesh;
import dev.tigr.mesh.impl.client.util.SessionMesh;
import net.minecraft.client.Minecraft;

/**
 * Mesh API interface for Minecraft's main class
 *
 * @author Tigermouthbear 1/1/22
 */
public class MinecraftMesh implements IMinecraft {
    private final Minecraft minecraft;
    private final SessionMesh session;
    private final ProfilerMesh profiler;

    public MinecraftMesh(Minecraft minecraft) {
        this.minecraft = minecraft;
        this.session = new SessionMesh(minecraft.getSession());
        this.profiler = new ProfilerMesh(minecraft.profiler);
    }

    @Override
    public IProfiler getProfiler() {
        return profiler;
    }

    @Override
    public ISession getSession() {
        return session;
    }
}
