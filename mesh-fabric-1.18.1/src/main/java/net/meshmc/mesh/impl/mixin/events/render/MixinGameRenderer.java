package net.meshmc.mesh.impl.mixin.events.render;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.event.events.render.RenderEvent;
import net.meshmc.mesh.impl.wrapper.render.MatrixStackMesh;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "renderHand", at = @At("HEAD"))
    public void renderWorld(MatrixStack matrices, Camera camera, float tickDelta, CallbackInfo ci) {
        ((MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack()).setMatrixStack(matrices);
        Mesh.getMesh().getEventManager().post(new RenderEvent.World(tickDelta));
        ((MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack()).setMatrixStack(new MatrixStack());
    }
}
