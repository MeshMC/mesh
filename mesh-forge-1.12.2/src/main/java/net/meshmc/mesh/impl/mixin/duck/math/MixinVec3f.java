package net.meshmc.mesh.impl.mixin.duck.math;

import net.meshmc.mesh.impl.mixininterface.math.Vec3f;
import org.lwjgl.util.vector.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Vector3f.class)
public class MixinVec3f implements Vec3f {
    @Shadow public float x;
    @Shadow public float y;
    @Shadow public float z;

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }

    @Override
    public void setX(float value) {
        x = value;
    }

    @Override
    public void setY(float value) {
        y = value;
    }

    @Override
    public void setZ(float value) {
        z = value;
    }
}
