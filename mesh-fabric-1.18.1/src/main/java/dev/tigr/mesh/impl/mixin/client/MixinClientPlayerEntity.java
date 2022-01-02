package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.events.Era;
import dev.tigr.mesh.events.client.TickEvent;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity {
    @Inject(method = "tickMovement", at = @At("HEAD"))
    public void preMotion(CallbackInfo ci) {
        TickEvent.Motion.post(Era.BEFORE);
    }

    @Inject(method = "tickMovement", at = @At("RETURN"))
    public void postMotion(CallbackInfo ci) {
        TickEvent.Motion.post(Era.AFTER);
    }
}
