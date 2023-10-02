package net.meshmc.mesh.impl.mixin.events.client;

import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.event.MeshEvent;
import net.meshmc.mesh.event.events.client.ScreenOpenedEvent;
import net.meshmc.mesh.event.events.client.TickEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo ci) {
        MeshAPI.getEventManager().post(new TickEvent.Client(MeshEvent.Era.BEFORE));
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void postTick(CallbackInfo ci) {
        MeshAPI.getEventManager().post(new TickEvent.Client(MeshEvent.Era.AFTER));
    }

    @Inject(method = "render", at = @At("HEAD"))
    public void preGameLoop(boolean tick, CallbackInfo ci) {
        MeshAPI.getEventManager().post(new TickEvent.GameLoop(MeshEvent.Era.BEFORE));
    }

    @Inject(method = "render", at = @At("RETURN"))
    public void postGameLoop(boolean tick, CallbackInfo ci) {
        MeshAPI.getEventManager().post(new TickEvent.GameLoop(MeshEvent.Era.AFTER));
    }

    @Inject(method = "setScreen", at = @At("RETURN"))
    public void postSetScreen(Screen screen, CallbackInfo ci) {
        MeshAPI.getEventManager().post(new ScreenOpenedEvent(screen instanceof TitleScreen));
    }
}
