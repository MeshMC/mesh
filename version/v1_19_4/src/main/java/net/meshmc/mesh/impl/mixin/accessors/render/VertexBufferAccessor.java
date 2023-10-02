package net.meshmc.mesh.impl.mixin.accessors.render;

import net.minecraft.client.gl.VertexBuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VertexBuffer.class)
public interface VertexBufferAccessor {
    @Accessor("vertexArrayId")
    int getVertexArrayId();

    @Accessor("vertexArrayId")
    void setVertexArrayId(int vao);

    @Accessor("vertexBufferId")
    int getVertexBufferId();

    @Accessor("vertexBufferId")
    void setVertexBufferId(int vbo);

    @Accessor("indexBufferId")
    int getIndexBufferId();

    @Accessor("indexBufferId")
    void setIndexBufferId(int ibo);
}
