package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.util.render.Color;
import net.minecraft.client.gui.FontRenderer;

/**
 * @author Tigermouthbear 1/15/22
 */
public class TextRendererMesh extends TextRenderer<FontRenderer> {
    public TextRendererMesh(FontRenderer value) {
        super(value);
    }

    @Override
    public void drawText(String text, float x, float y, Color color) {
        getMeshValue().drawString(text, (int) x, (int) y, color.getRGB());
    }

    @Override
    public void drawTextWithShadow(String text, float x, float y, Color color) {
        getMeshValue().drawStringWithShadow(text, (int) x, (int) y, color.getRGB());
    }
}
