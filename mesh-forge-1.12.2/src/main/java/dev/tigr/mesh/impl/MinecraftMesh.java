package dev.tigr.mesh.impl;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.api.world.ClientWorld;
import dev.tigr.mesh.impl.render.TextRendererMesh;
import dev.tigr.mesh.impl.util.ProfilerMesh;
import dev.tigr.mesh.impl.util.SessionMesh;
import dev.tigr.mesh.impl.mixin.accessors.MinecraftAccessor;
import dev.tigr.mesh.impl.world.ClientWorldMesh;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MinecraftMesh extends AbstractMesh<Minecraft> implements dev.tigr.mesh.api.Minecraft<Minecraft> {
    public MinecraftMesh(net.minecraft.client.Minecraft value) {
        super(value);
    }

    @Override
    public Profiler<?> getProfiler() {
        return new ProfilerMesh(getMeshValue().profiler);
    }

    @Override
    public TextRenderer<?> getTextRenderer() {
        return new TextRendererMesh(getMeshValue().fontRenderer);
    }

    @Override
    public Session<?> getSession() {
        return new SessionMesh(getMeshValue().getSession());
    }

    @Override
    public void setSession(Session<?> session) {
        ((MinecraftAccessor) getMeshValue()).setSession((net.minecraft.util.Session) session.getMeshValue());
    }

    @Override
    public ClientWorld<?> getWorld() {
        return new ClientWorldMesh(getMeshValue().world);
    }

    @Override
    public void setWorld(ClientWorld<?> worldIn) {
        getMeshValue().world = (WorldClient) worldIn.getMeshValue();
    }
}
