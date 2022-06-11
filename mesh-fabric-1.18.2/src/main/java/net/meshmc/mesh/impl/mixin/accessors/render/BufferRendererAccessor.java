package net.meshmc.mesh.impl.mixin.accessors.render;

import net.minecraft.client.render.BufferRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BufferRenderer.class)
public interface BufferRendererAccessor {
    @Accessor("currentVertexArray")
    static int getCurrentVertexArray() {
        throw new AssertionError();
    }

    @Accessor("currentVertexArray")
    static void setCurrentVertexArray(int vao) {
        throw new AssertionError();
    }

    @Accessor("currentVertexBuffer")
    static int getCurrentVertexBuffer() {
        throw new AssertionError();
    }

    @Accessor("currentVertexBuffer")
    static void setCurrentVertexBuffer(int vbo) {
        throw new AssertionError();
    }

    @Accessor("currentElementBuffer")
    static int getCurrentElementBuffer() {
        throw new AssertionError();
    }

    @Accessor("currentElementBuffer")
    static void setCurrentElementBuffer(int ibo) {
        throw new AssertionError();
    }
}
