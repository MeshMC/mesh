package dev.tigr.mesh.impl.client.math;

import dev.tigr.mesh.api.math.Vec3d;

/**
 * @author Tigermouthbear 1/13/22
 */
public class Vec3dMesh extends Vec3d<net.minecraft.util.math.Vec3d> {
    public Vec3dMesh(net.minecraft.util.math.Vec3d value) {
        super(value);
    }

    @Override
    public double getX() {
        return getMeshValue().x;
    }

    @Override
    public double getY() {
        return getMeshValue().y;
    }

    @Override
    public double getZ() {
        return getMeshValue().z;
    }
}
