package net.meshmc.mesh.impl.mixin.accessors.render;

import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.VertexFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BufferBuilder.class)
public interface BufferBuilderAccessor {
    @Accessor("format")
    VertexFormat getVertexFormat();

    @Accessor("drawMode")
    VertexFormat.DrawMode getDrawMode();
}
