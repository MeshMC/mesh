package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.events.MeshEvent;
import dev.tigr.mesh.events.client.TickEvent;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
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
}
