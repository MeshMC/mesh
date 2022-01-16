package dev.tigr.mesh.impl.math;

import dev.tigr.mesh.api.math.BlockPos;

/**
 * @author Tigermouthbear 1/13/22
 */
public class BlockPosMesh extends BlockPos<net.minecraft.util.math.BlockPos> {
    public BlockPosMesh(net.minecraft.util.math.BlockPos value) {
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
