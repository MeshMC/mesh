package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.events.Era;
import dev.tigr.mesh.events.client.TickEvent;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class MixinClientWorld {
    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        TickEvent.World.post(Era.BEFORE);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        TickEvent.World.post(Era.AFTER);
    }
}
