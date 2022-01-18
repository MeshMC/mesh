package dev.tigr.mesh.impl;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.Minecraft;
import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.api.world.ClientWorld;
import dev.tigr.mesh.impl.render.TextRendererMesh;
import dev.tigr.mesh.impl.util.ProfilerMesh;
import dev.tigr.mesh.impl.util.SessionMesh;
import dev.tigr.mesh.impl.mixin.accessors.MinecraftClientAccessor;
import dev.tigr.mesh.impl.world.ClientWorldMesh;
import net.minecraft.client.MinecraftClient;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MinecraftMesh extends AbstractMesh<MinecraftClient> implements Minecraft<MinecraftClient> {
    public MinecraftMesh(MinecraftClient value) {
        super(value);
    }

    @Override
    public Profiler<?> getProfiler() {
        return new ProfilerMesh(getMeshValue().getProfiler());
    }

    @Override
    public TextRenderer<?> getTextRenderer() {
        return new TextRendererMesh(getMeshValue().textRenderer);
    }

    @Override
    public Session<?> getSession() {
        return new SessionMesh(getMeshValue().getSession());
    }

    @Override
    public void setSession(Session<?> session) {
        ((MinecraftClientAccessor) getMeshValue()).setSession((net.minecraft.client.util.Session) session.getMeshValue());
    }

    @Override
    public ClientWorld<?> getWorld() {
        return new ClientWorldMesh(getMeshValue().world);
    }

    @Override
    public void setWorld(ClientWorld<?> worldIn) {
        getMeshValue().world = (net.minecraft.client.world.ClientWorld) worldIn.getMeshValue();
    }
}
