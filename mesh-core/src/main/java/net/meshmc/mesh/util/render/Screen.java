package net.meshmc.mesh.util.render;

/**
 * Represents a minecraft gui screen across versions
 * @author Tigermouthbear 1/10/22
 */
public class Screen {
    private final String title;

    public Screen(String title) {
        this.title = title;
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

    // TODO: ADD MORE HELPER FUNCTIONS
}
