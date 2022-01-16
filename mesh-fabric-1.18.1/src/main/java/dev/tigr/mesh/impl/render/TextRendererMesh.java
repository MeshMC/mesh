package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.util.render.Color;

/**
 * @author Tigermouthbear 1/15/22
 */
public class TextRendererMesh extends TextRenderer<net.minecraft.client.font.TextRenderer> {
    public TextRendererMesh(net.minecraft.client.font.TextRenderer value) {
        super(value);
    }

    @Override
    public void drawText(String text, float x, float y, Color color) {
        getMeshValue().draw(((MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack()).getMatrixStack(), text, x, y, color.getRGB());
    }

    @Override
    public void drawTextWithShadow(String text, float x, float y, Color color) {
        getMeshValue().drawWithShadow(((MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack()).getMatrixStack(), text, x, y, color.getRGB());
    }
}
