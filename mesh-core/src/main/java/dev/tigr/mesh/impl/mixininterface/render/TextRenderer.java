package dev.tigr.mesh.impl.mixininterface.render;

import dev.tigr.mesh.util.render.Color;

/**
 * Provides a mesh interface for rendering text through minecraft's font renderer
 * // TODO: MORE HELPER FUNCTIONS
 * @author Tigermouthbear 1/15/22
 */
public interface TextRenderer {
    void drawText(String text, float x, float y, Color color);
    void drawTextWithShadow(String text, float x, float y, Color color);
}
