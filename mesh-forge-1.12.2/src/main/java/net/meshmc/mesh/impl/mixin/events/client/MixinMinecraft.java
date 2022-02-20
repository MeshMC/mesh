package net.meshmc.mesh.impl.mixin.events.client;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.TickEvent;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "runTick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent.Client(MeshEvent.Era.BEFORE));
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent.Client(MeshEvent.Era.AFTER));
    }

    @Inject(method = "runGameLoop", at = @At("HEAD"))
    public void preGameLoop(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent.GameLoop(MeshEvent.Era.BEFORE));
    }

    @Inject(method = "runGameLoop", at = @At("RETURN"))
    public void postGameLoop(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent.GameLoop(MeshEvent.Era.AFTER));
    }
}
