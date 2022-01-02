package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.events.Era;
import dev.tigr.mesh.events.client.TickEvent;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        TickEvent.Client.post(Era.BEFORE);
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        TickEvent.Client.post(Era.AFTER);
    }

    @Inject(method = "render", at = @At("HEAD"))
    public void preGameLoop(boolean tick, CallbackInfo ci) {
        TickEvent.GameLoop.post(Era.BEFORE);
    }

    @Inject(method = "render", at = @At("RETURN"))
    public void postGameLoop(boolean tick, CallbackInfo ci) {
        TickEvent.GameLoop.post(Era.AFTER);
    }
}
