package net.meshmc.mesh.impl.mixin.duck.math;

import net.meshmc.mesh.impl.mixininterface.math.Vec3i;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(net.minecraft.util.math.Vec3i.class)
public class MixinVec3i implements Vec3i {
    @Mutable @Shadow @Final private int x;
    @Mutable @Shadow @Final private int y;
    @Mutable @Shadow @Final private int z;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public void setX(int value) {
        x = value;
    }

    @Override
    public void setY(int value) {
        y = value;
    }

    @Override
    public void setZ(int value) {
        z = value;
    }
}
