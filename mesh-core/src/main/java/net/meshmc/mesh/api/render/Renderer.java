package net.meshmc.mesh.api.render;

import net.meshmc.mesh.api.render.buffer.BufferBuilder;
import net.meshmc.mesh.api.render.buffer.MatrixStack;
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

    private final MatrixStack renderStack;
    private final RenderState renderState;
    private final BufferBuilder<?> bufferBuilder;

    public Renderer(MatrixStack renderStack, RenderState renderState, BufferBuilder<?> bufferBuilder) {
        this.renderStack = renderStack;
        this.renderState = renderState;
        this.bufferBuilder = bufferBuilder;
    }

    public abstract void bindTexture(LocationIdentifier locationIdentifier);

    public MatrixStack getRenderStack() {
        return renderStack;
    }

    public RenderState getRenderState() {
        return renderState;
    }

    public abstract Camera getCamera();

    public BufferBuilder<?> getBufferBuilder() {
        return bufferBuilder;
    }
}
