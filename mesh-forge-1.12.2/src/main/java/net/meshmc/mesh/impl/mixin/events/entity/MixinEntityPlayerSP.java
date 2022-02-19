package net.meshmc.mesh.impl.mixin.events.entity;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.TickEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {
    @Inject(method = "onLivingUpdate", at = @At("HEAD"))
    public void preMotion(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.MOTION, MeshEvent.Era.BEFORE));
    }

    @Inject(method = "onLivingUpdate", at = @At("RETURN"))
    public void postMotion(CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new TickEvent(TickEvent.Type.MOTION, MeshEvent.Era.AFTER));
    }
}
