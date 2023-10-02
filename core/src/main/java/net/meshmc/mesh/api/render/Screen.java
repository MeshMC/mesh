package net.meshmc.mesh.api.render;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.client.Minecraft;

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

    public void scroll(int mouseX, int mouseY, double value) {
    }

    // TODO: THIS ISNT CONSISTENT ACROSS VERSIONS
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

    public static void openChatScreen(String input) {
        MeshStatics.openChatScreen(input);
    }

    public static void openDemoScreen() {
        MeshStatics.openDemoScreen();
    }

    public static void openMultiplayerScreen() {
        MeshStatics.openMultiplayerScreen();
    }

    public static void openOptionsScreen() {
        MeshStatics.openOptionsScreen();
    }

    public static void openSelectWorldScreen() {
        MeshStatics.openSelectWorldScreen();
    }

    public static void openRealmsMainScreen() {
        MeshStatics.openRealmsMainScreen();
    }

    public static void openTitleScreen() {
        MeshStatics.openTitleScreen();
    }

    // TODO: ADD MORE HELPER FUNCTIONS
}
