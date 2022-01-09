package dev.tigr.mesh.impl.mixin.accessors;

import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Box.class)
public interface BoxAccessor {
    @Accessor("minX")
    void setMinX(double minX);

    @Accessor("minY")
    void setMinY(double minY);

    @Accessor("minZ")
    void setMinZ(double minZ);

    @Accessor("maxX")
    void setMaxX(double maxX);

    @Accessor("maxY")
    void setMaxY(double maxY);

    @Accessor("maxZ")
    void setMaxZ(double maxZ);
}
