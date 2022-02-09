package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.event.MeshEvent;
import dev.tigr.mesh.event.events.TickEvent;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import dev.tigr.mesh.impl.mixininterface.render.TextRenderer;
import dev.tigr.mesh.impl.mixininterface.util.Session;
import dev.tigr.mesh.impl.mixininterface.world.ClientWorld;
import dev.tigr.mesh.impl.util.ProfilerMesh;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft implements dev.tigr.mesh.impl.mixininterface.client.Minecraft {
    @Shadow @Final public net.minecraft.profiler.Profiler profiler;
    @Shadow public FontRenderer fontRenderer;
    @Mutable @Shadow @Final private net.minecraft.util.Session session;
    @Shadow public WorldClient world;
    @Shadow public EntityPlayerSP player;

    @Inject(method = "runTick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.CLIENT, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.CLIENT, MeshEvent.Era.AFTER));
    }

    @Inject(method = "runGameLoop", at = @At("HEAD"))
    public void preGameLoop(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.GAMELOOP, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "runGameLoop", at = @At("RETURN"))
    public void postGameLoop(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.GAMELOOP, MeshEvent.Era.AFTER));
    }

    @Override
    public Profiler<?> getProfiler() {
        return new ProfilerMesh(profiler);
    }

    @Override
    public TextRenderer getTextRenderer() {
        return (TextRenderer) fontRenderer;
    }

    @Override
    public Session getSession() {
        return (Session) session;
    }

    @Override
    public void setSession(Session session) {
        this.session = (net.minecraft.util.Session) session;
    }

    @Override
    public ClientWorld getWorld() {
        return (ClientWorld) world;
    }

    @Override
    public void setWorld(ClientWorld world) {
        this.world = (WorldClient) world;
    }

    @Override
    public EntityClientPlayer getPlayer() {
        return (EntityClientPlayer) player;
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        this.player = (EntityPlayerSP) player;
    }
}
