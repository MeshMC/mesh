package dev.tigr.mesh.impl.mixin.accessors;

import net.minecraft.util.math.Vec2f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Vec2f.class)
public interface Vec2fAccessor {
    @Mutable
    @Accessor("x")
    void setX(float x);

    @Mutable
    @Accessor("y")
    void setY(float y);
}
