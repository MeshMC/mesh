package net.meshmc.mesh.impl.mixin.accessors;

import net.minecraft.block.material.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MapColor.class)
public interface MapColorAccessor {
    @Invoker("<init>")
    static MapColor create(int id, int color) {
        throw new RuntimeException();
    }
}
