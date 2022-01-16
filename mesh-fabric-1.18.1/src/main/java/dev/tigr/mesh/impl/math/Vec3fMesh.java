package dev.tigr.mesh.impl.math;

import dev.tigr.mesh.api.math.Vec3f;

/**
 * @author Tigermouthbear 1/15/22
 */
public class Vec3fMesh extends Vec3f<net.minecraft.util.math.Vec3f> {
    public Vec3fMesh(net.minecraft.util.math.Vec3f value) {
        super(value);
    }

    @Override
    public float getX() {
        return getMeshValue().getX();
    }

    @Override
    public float getY() {
        return getMeshValue().getY();
    }

    @Override
    public float getZ() {
        return getMeshValue().getZ();
    }
}
