package net.meshmc.mesh.api.render;

import net.meshmc.mesh.api.util.LocationIdentifier;

/**
 * Holds the mesh implementations of rendering calls
 * @author Tigermouthbear 1/15/22
 */
public abstract class Renderer {
    public enum DrawMode {
        LINES,
        LINE_STRIP,
        TRIANGLES,
        TRIANGLE_STRIP,
        TRIANGLE_FAN,
        QUADS
    }

    public enum VertexFormat {
        POSITION_COLOR,
        POSITION_TEXTURE,
        POSITION_TEXTURE_COLOR,
        LINES
    }

    private final IMatrixStack renderStack;
    private final IRenderState renderState;
    private final BufferBuilder<?> bufferBuilder;

    public Renderer(IMatrixStack renderStack, IRenderState renderState, BufferBuilder<?> bufferBuilder) {
        this.renderStack = renderStack;
        this.renderState = renderState;
        this.bufferBuilder = bufferBuilder;
    }

    public abstract void bindTexture(LocationIdentifier locationIdentifier);

    public IMatrixStack getRenderStack() {
        return renderStack;
    }

    public IRenderState getRenderState() {
        return renderState;
    }

    public BufferBuilder<?> getBufferBuilder() {
        return bufferBuilder;
    }
}
