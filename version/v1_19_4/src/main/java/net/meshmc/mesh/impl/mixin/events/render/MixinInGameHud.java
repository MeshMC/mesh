package net.meshmc.mesh.impl.mixin.events.render;

import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.event.events.render.RenderEvent;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Inject(method = "render", at = @At(value = "FIELD", target = "Lnet/minecraft/client/option/GameOptions;heldItemTooltips:Z"))
    public void renderOverlayPost(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        MeshAPI.getEventManager().post(new RenderEvent.Hud(tickDelta));
    }
}
