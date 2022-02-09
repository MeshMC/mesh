package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.event.MeshEvent;
import dev.tigr.mesh.event.events.TickEvent;
import dev.tigr.mesh.impl.mixininterface.client.Minecraft;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import dev.tigr.mesh.impl.mixininterface.render.TextRenderer;
import dev.tigr.mesh.impl.mixininterface.util.Session;
import dev.tigr.mesh.impl.mixininterface.world.ClientWorld;
import dev.tigr.mesh.impl.util.ProfilerMesh;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient implements Minecraft {
    @Shadow private net.minecraft.util.profiler.Profiler profiler;
    @Shadow @Final public net.minecraft.client.font.TextRenderer textRenderer;
    @Mutable @Shadow @Final private net.minecraft.client.util.Session session;
    @Shadow @Nullable public net.minecraft.client.world.ClientWorld world;
    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.CLIENT, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.CLIENT, MeshEvent.Era.AFTER));
    }

    @Inject(method = "render", at = @At("HEAD"))
    public void preGameLoop(boolean tick, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.GAMELOOP, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "render", at = @At("RETURN"))
    public void postGameLoop(boolean tick, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.GAMELOOP, MeshEvent.Era.AFTER));
    }

    @Override
    public Profiler<?> getProfiler() {
        return new ProfilerMesh(profiler);
    }

    @Override
    public TextRenderer getTextRenderer() {
        return (TextRenderer) textRenderer;
    }

    @Override
    public Session getSession() {
        return (Session) session;
    }

    @Override
    public void setSession(Session session) {
        this.session = (net.minecraft.client.util.Session) session;
    }

    @Override
    public ClientWorld getWorld() {
        return (ClientWorld) world;
    }

    @Override
    public void setWorld(ClientWorld world) {
        this.world = (net.minecraft.client.world.ClientWorld) world;
    }

    @Override
    public EntityClientPlayer getPlayer() {
        return (EntityClientPlayer) player;
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        this.player = (ClientPlayerEntity) player;
    }
}
