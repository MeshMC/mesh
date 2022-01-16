package dev.tigr.mesh.api.render;

import dev.tigr.mesh.util.render.LocationIdentifier;

/**
 * Holds the mesh implementations of rendering calls
 * @author Tigermouthbear 1/15/22
 */
public abstract class Renderer {
    public enum DrawMode {
        LINES,
        TRIANGLES,
        QUADS
    }

    public enum VertexFormat {
        POSITION_COLOR,
        POSITION_TEXTURE,
        POSITION_TEXTURE_COLOR,
        POSITION_TEXTURE_COLOR_NORMAL,
        LINES
    }

    private final IMatrixStack renderStack;
    private final IRenderState renderState;

    public Renderer(IMatrixStack renderStack, IRenderState renderState) {
        this.renderStack = renderStack;
        this.renderState = renderState;
    }

    public abstract void bindTexture(LocationIdentifier locationIdentifier);

    public abstract BufferBuilder<?> begin(DrawMode drawMode, VertexFormat vertexFormat);

    public abstract void draw();

    public IMatrixStack getRenderStack() {
        return renderStack;
    }

    public IRenderState getRenderState() {
        return renderState;
    }
}
