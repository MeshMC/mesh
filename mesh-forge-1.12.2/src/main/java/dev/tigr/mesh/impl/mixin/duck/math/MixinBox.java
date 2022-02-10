package dev.tigr.mesh.impl.mixin.duck.math;

import dev.tigr.mesh.impl.mixininterface.math.Box;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.util.math.AxisAlignedBB.class)
public class MixinBox implements Box {
    @Shadow @Final public double minX;
    @Shadow @Final public double minY;
    @Shadow @Final public double minZ;
    @Shadow @Final public double maxX;
    @Shadow @Final public double maxY;
    @Shadow @Final public double maxZ;

    @Override
    public double getMinX() {
        return minX;
    }

    @Override
    public double getMinY() {
        return minY;
    }

    @Override
    public double getMinZ() {
        return minZ;
    }

    @Override
    public double getMaxX() {
        return maxX;
    }

    @Override
    public double getMaxY() {
        return maxY;
    }

    @Override
    public double getMaxZ() {
        return maxZ;
    }
}
