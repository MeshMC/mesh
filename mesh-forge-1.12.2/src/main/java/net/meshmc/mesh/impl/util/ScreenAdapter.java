package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.render.Screen;
import net.meshmc.mesh.api.render.ScreenContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;

import java.io.IOException;

/**
 * Wraps a mesh screen around minecraft's GuiScreen class so that native methods can be called
 * @author Tigermouthbear 2/27/22
 */
public class ScreenAdapter extends GuiScreen {
    private final Screen screen;

    public ScreenAdapter(Screen screen) {
        this.screen = screen;
        screen.setContext((ScreenContext) this);
    }

    @Override
    public void initGui() {
        screen.init();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if(Mouse.hasWheel()) screen.scroll(mouseX, mouseY, Mouse.getDWheel() / 10d);
        screen.render(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        screen.click(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        screen.release(mouseX, mouseY, mouseButton);
        super.mouseReleased(mouseX, mouseY, mouseButton);
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {
        if(screen.shouldCloseOnEsc()) super.keyTyped(typedChar, keyCode);
        screen.type(typedChar, keyCode);
    }

    @Override
    public void onResize(Minecraft mc, int w, int h) {
        screen.resize(w, h);
        super.onResize(mc, w, h);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return screen.shouldPause();
    }

    @Override
    public void onGuiClosed() {
        screen.close();
        super.onGuiClosed();
    }
}
