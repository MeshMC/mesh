package net.meshmc.mesh.api.render;

import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.util.render.Resolution;

/**
 * Represents a minecraft gui screen across versions
 * @author Tigermouthbear 1/10/22
 */
public class Screen implements ScreenContext {
    private ScreenContext context = null;
    private final String title;

    public Screen(String title) {
        this.title = title;
    }

    public void init() {
    }

    public void render(int mouseX, int mouseY, float partialTicks) {
    }

    public void click(int mouseX, int mouseY, int mouseButton) {
    }

    public void release(int mouseX, int mouseY, int mouseButton) {
    }

    public void type(Character typedChar, int keyCode) {
    }

    public void scroll(double mouseX, double mouseY, double value) {
    }

    // TODO: THIS ISNT CONSISTEN ACROSS VERSIONS
    public void resize(int width, int height) {
    }

    public void close() {
    }

    public boolean shouldCloseOnEsc() {
        return true;
    }

    public boolean shouldPause() {
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setContext(ScreenContext context) {
        this.context = context;
    }

    @Override
    public int getWidth() {
        return context.getWidth();
    }

    @Override
    public void setWidth(int width) {
        context.setWidth(width);
    }

    @Override
    public int getHeight() {
        return context.getHeight();
    }

    @Override
    public void setHeight(int height) {
        context.setHeight(height);
    }

    @Override
    public Minecraft getMinecraft() {
        return context.getMinecraft();
    }

    @Override
    public void setMinecraft(Minecraft minecraft) {
        context.setMinecraft(minecraft);
    }

    // TODO: ADD MORE HELPER FUNCTIONS
}
