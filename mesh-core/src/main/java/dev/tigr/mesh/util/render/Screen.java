package dev.tigr.mesh.util.render;

/**
 * Represents a minecraft gui screen across versions
 * @author Tigermouthbear 1/10/22
 */
public interface Screen {
    void drawScreen(int mouseX, int mouseY, float partialTicks);

    void mouseClicked(int mouseX, int mouseY, int mouseButton);

    void mouseReleased(int mouseX, int mouseY, int mouseButton);

    void keyTyped(Character typedChar, int keyCode);

    void mouseScrolled(double mouseX, double mouseY, double value);

    void onGuiClosed();
}
