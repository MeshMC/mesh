package dev.tigr.mesh.impl.mixin.render;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.impl.render.MatrixStackMesh;
import dev.tigr.mesh.util.render.Color;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TextRenderer.class)
public abstract class MixinTextRenderer implements dev.tigr.mesh.impl.mixininterface.render.TextRenderer {
    @Shadow public abstract int draw(MatrixStack matrices, String text, float x, float y, int color);
    @Shadow public abstract int drawWithShadow(MatrixStack matrices, String text, float x, float y, int color);

    @Override
    public void drawText(String text, float x, float y, Color color) {
        draw(((MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack()).getMatrixStack(), text, x, y, color.getRGB());
    }

    @Override
    public void drawTextWithShadow(String text, float x, float y, Color color) {
        drawWithShadow(((MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack()).getMatrixStack(), text, x, y, color.getRGB());
    }
}
