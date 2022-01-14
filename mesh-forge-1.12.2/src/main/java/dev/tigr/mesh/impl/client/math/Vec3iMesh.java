package dev.tigr.mesh.impl.client.math;

import dev.tigr.mesh.api.math.Vec3i;

/**
 * @author Tigermouthbear 1/13/22
 */
public class Vec3iMesh extends Vec3i<net.minecraft.util.math.Vec3i> {
    public Vec3iMesh(net.minecraft.util.math.Vec3i value) {
        super(value);
    }

    @Override
    public int getX() {
        return getMeshValue().getX();
    }

    @Override
    public int getY() {
        return getMeshValue().getY();
    }

    @Override
    public int getZ() {
        return getMeshValue().getZ();
    }
}
