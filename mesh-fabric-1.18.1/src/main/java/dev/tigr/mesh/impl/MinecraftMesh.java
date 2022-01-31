package dev.tigr.mesh.impl;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.Minecraft;
import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import dev.tigr.mesh.impl.mixininterface.world.ClientWorld;
import dev.tigr.mesh.impl.render.TextRendererMesh;
import dev.tigr.mesh.impl.util.ProfilerMesh;
import dev.tigr.mesh.impl.util.SessionMesh;
import dev.tigr.mesh.impl.mixin.accessors.MinecraftClientAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

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
    public ClientWorld getWorld() {
        return (ClientWorld) getMeshValue().world;
    }

    @Override
    public void setWorld(ClientWorld world) {
        getMeshValue().world = (net.minecraft.client.world.ClientWorld) world;
    }

    @Override
    public EntityClientPlayer getPlayer() {
        return (EntityClientPlayer) getMeshValue().player;
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        getMeshValue().player = (ClientPlayerEntity) player;
    }
}
