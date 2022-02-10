package dev.tigr.mesh.impl.mixin.events.entity;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.event.MeshEvent;
import dev.tigr.mesh.event.events.client.TickEvent;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity {
    @Inject(method = "tickMovement", at = @At("HEAD"))
    public void preMotion(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.MOTION, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tickMovement", at = @At("RETURN"))
    public void postMotion(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.MOTION, MeshEvent.Era.AFTER));
    }
}
