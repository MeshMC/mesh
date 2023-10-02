package net.meshmc.mesh.impl.mixin.render;

import net.meshmc.mesh.api.render.TextRenderer;
import net.meshmc.mesh.util.render.Color;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FontRenderer.class)
public abstract class MixinTextRenderer implements TextRenderer {
    @Shadow public abstract int drawString(String text, int x, int y, int color);
    @Shadow public abstract int drawStringWithShadow(String text, float x, float y, int color);

    @Override
    public void drawText(String text, float x, float y, Color color) {
        drawString(text, (int) x, (int) y, color.getRGB());
    }

    @Override
    public void drawTextWithShadow(String text, float x, float y, Color color) {
        drawStringWithShadow(text, (int) x, (int) y, color.getRGB());
    }
}
