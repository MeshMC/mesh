package net.meshmc.mesh.impl.mixin.events.entity;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.TickEvent;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity {
    @Inject(method = "tickMovement", at = @At("HEAD"))
    public void preMotion(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent.Motion(MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tickMovement", at = @At("RETURN"))
    public void postMotion(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent.Motion(MeshEvent.Era.AFTER));
    }
}
