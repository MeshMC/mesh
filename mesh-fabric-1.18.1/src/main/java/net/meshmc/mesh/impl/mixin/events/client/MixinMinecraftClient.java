package net.meshmc.mesh.impl.mixin.events.client;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.TickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
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
}
