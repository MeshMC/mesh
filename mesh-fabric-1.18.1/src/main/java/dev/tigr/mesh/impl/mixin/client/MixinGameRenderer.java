package dev.tigr.mesh.impl.mixin.client;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.event.events.render.HudRenderEvent;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;render(Lnet/minecraft/client/util/math/MatrixStack;F)V"))
    private void render(float tickDelta, long startTime, boolean tick, CallbackInfo ci) {
        Mesh.getMesh().getEventManager().post(new HudRenderEvent());
    }
}
