package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.render.buffer.BufferRenderer;
import net.meshmc.mesh.impl.mixin.accessors.render.BufferRendererAccessor;
import net.meshmc.mesh.impl.mixin.accessors.render.VertexBufferAccessor;

public class BufferRendererMesh implements BufferRenderer {
    @Override
    public int getVertexArray() {
        return ((VertexBufferAccessor) BufferRendererAccessor.getCurrentVertexBuffer()).getVertexArrayId();
    }

    @Override
    public void setVertexArray(int vao) {
        ((VertexBufferAccessor) BufferRendererAccessor.getCurrentVertexBuffer()).setVertexArrayId(vao);
    }

    @Override
    public int getVertexBuffer() {
        return ((VertexBufferAccessor) BufferRendererAccessor.getCurrentVertexBuffer()).getVertexBufferId();
    }

    @Override
    public void setVertexBuffer(int vbo) {
        ((VertexBufferAccessor) BufferRendererAccessor.getCurrentVertexBuffer()).setVertexBufferId(vbo);
    }

    @Override
    public int getElementBuffer() {
        return ((VertexBufferAccessor) BufferRendererAccessor.getCurrentVertexBuffer()).getIndexBufferId();
    }

    @Override
    public void setElementBuffer(int ibo) {
        ((VertexBufferAccessor) BufferRendererAccessor.getCurrentVertexBuffer()).setIndexBufferId(ibo);
    }
}
