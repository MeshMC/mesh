package net.meshmc.mesh.impl.mixin.render;

import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.impl.wrapper.render.MatrixStackMesh;
import net.meshmc.mesh.util.render.Color;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TextRenderer.class)
public abstract class MixinTextRenderer implements net.meshmc.mesh.api.render.TextRenderer {
    @Shadow public abstract int draw(MatrixStack matrices, String text, float x, float y, int color);
    @Shadow public abstract int drawWithShadow(MatrixStack matrices, String text, float x, float y, int color);

    @Override
    public void drawText(String text, float x, float y, Color color) {
        draw(((MatrixStackMesh) MeshAPI.getRenderer().getRenderStack()).getMatrixStack(), text, x, y, color.getRGB());
    }

    @Override
    public void drawTextWithShadow(String text, float x, float y, Color color) {
        drawWithShadow(((MatrixStackMesh) MeshAPI.getRenderer().getRenderStack()).getMatrixStack(), text, x, y, color.getRGB());
    }
}
