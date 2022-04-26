package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.util.render.Screen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

/**
 * Wraps a mesh screen around minecraft's Screen class so that native methods can be called
 * @author Tigermouthbear 2/27/22
 */
public class ScreenAdapter extends net.minecraft.client.gui.screen.Screen {
    private final Screen screen;

    public ScreenAdapter(Screen screen) {
        super(new LiteralText(screen.getTitle()));
        this.screen = screen;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        screen.render(mouseX, mouseY, partialTicks);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        screen.click((int) mouseX, (int) mouseY, mouseButton);
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int mouseButton) {
        screen.release((int) mouseX, (int) mouseY, mouseButton);
        return super.mouseReleased(mouseX, mouseY, mouseButton);
    }

    @Override
    public boolean charTyped(char character, int keycode) {
        screen.type(character, keycode);
        return super.charTyped(character, keycode);
    }

    @Override
    public boolean keyPressed(int keycode, int something, int mods) {
        screen.type(null, keycode);
        return super.keyPressed(keycode, something, mods);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double value) {
        screen.scroll(mouseX, mouseY, value);
        return super.mouseScrolled(mouseX, mouseY, value);
    }

    @Override
    public void resize(MinecraftClient client, int width, int height) {
        screen.resize(width, height);
        super.resize(client, width, height);
    }

    @Override
    public boolean shouldPause() {
        return screen.shouldPause();
    }

    @Override
    public boolean shouldCloseOnEsc() {
        return screen.shouldCloseOnEsc();
    }

    @Override
    public void close() {
        screen.close();
        super.close();
    }
}
