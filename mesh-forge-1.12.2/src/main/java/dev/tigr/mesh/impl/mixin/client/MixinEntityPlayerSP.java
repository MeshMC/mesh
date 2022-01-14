package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.events.MeshEvent;
import dev.tigr.mesh.events.client.TickEvent;
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
