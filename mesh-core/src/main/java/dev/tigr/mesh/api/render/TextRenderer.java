package dev.tigr.mesh.api.render;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.util.render.Color;

/**
 * Provides a mesh interface for rendering text through minecraft's font renderer
 * // TODO: MORE HELPER FUNCTIONS
 * @author Tigermouthbear 1/15/22
 */
public abstract class TextRenderer<T> extends AbstractMesh<T> {
    public TextRenderer(T value) {
        super(value);
    }

    public abstract void drawText(String text, float x, float y, Color color);

    public abstract void drawTextWithShadow(String text, float x, float y, Color color);
}
