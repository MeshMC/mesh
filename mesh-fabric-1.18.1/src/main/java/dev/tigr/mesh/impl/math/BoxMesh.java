package dev.tigr.mesh.impl.math;

import dev.tigr.mesh.api.math.Box;

/**
 * @author Tigermouthbear 1/13/22
 */
public class BoxMesh extends Box<net.minecraft.util.math.Box> {
    public BoxMesh(net.minecraft.util.math.Box value) {
        super(value);
    }

    @Override
    public double getMinX() {
        return getMeshValue().minX;
    }

    @Override
    public double getMinY() {
        return getMeshValue().minY;
    }

    @Override
    public double getMinZ() {
        return getMeshValue().minZ;
    }

    @Override
    public double getMaxX() {
        return getMeshValue().maxX;
    }

    @Override
    public double getMaxY() {
        return getMeshValue().maxY;
    }

    @Override
    public double getMaxZ() {
        return getMeshValue().maxZ;
    }
}
