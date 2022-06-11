package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.render.buffer.BufferRenderer;
import net.meshmc.mesh.impl.mixin.accessors.render.BufferRendererAccessor;

public class BufferRendererMesh implements BufferRenderer {
    @Override
    public int getVertexArray() {
        return BufferRendererAccessor.getCurrentVertexArray();
    }

    @Override
    public void setVertexArray(int vao) {
        BufferRendererAccessor.setCurrentVertexArray(vao);
    }

    @Override
    public int getVertexBuffer() {
        return BufferRendererAccessor.getCurrentVertexBuffer();
    }

    @Override
    public void setVertexBuffer(int vbo) {
        BufferRendererAccessor.setCurrentVertexBuffer(vbo);
    }

    @Override
    public int getElementBuffer() {
        return BufferRendererAccessor.getCurrentElementBuffer();
    }

    @Override
    public void setElementBuffer(int ibo) {
        BufferRendererAccessor.setCurrentElementBuffer(ibo);
    }
}
