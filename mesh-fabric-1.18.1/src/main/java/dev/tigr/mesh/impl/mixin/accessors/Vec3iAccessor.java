package dev.tigr.mesh.impl.mixin.accessors;

import net.minecraft.util.math.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Vec3i.class)
public interface Vec3iAccessor {
    @Accessor("x")
    void setX(int x);

    @Accessor("y")
    void setY(int y);

    @Accessor("z")
    void setZ(int z);
}
