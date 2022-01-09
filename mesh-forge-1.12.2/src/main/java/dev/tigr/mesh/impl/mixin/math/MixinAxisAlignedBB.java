package dev.tigr.mesh.impl.mixin.math;

import dev.tigr.mesh.impl.mixininterface.IAxisAlignedBB;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AxisAlignedBB.class)
public class MixinAxisAlignedBB implements IAxisAlignedBB {
    @Mutable
    @Shadow @Final public double minX;

    @Mutable
    @Shadow @Final public double minY;

    @Mutable
    @Shadow @Final public double minZ;

    @Mutable
    @Shadow @Final public double maxX;

    @Mutable
    @Shadow @Final public double maxY;

    @Mutable
    @Shadow @Final public double maxZ;

    @Override
    public void setMinX(double minX) {
        this.minX = minX;
    }

    @Override
    public void setMinY(double minY) {
        this.minY = minY;
    }

    @Override
    public void setMinZ(double minZ) {
        this.minZ = minZ;
    }

    @Override
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    @Override
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    @Override
    public void setMaxZ(double maxZ) {
        this.maxZ = maxZ;
    }
}
