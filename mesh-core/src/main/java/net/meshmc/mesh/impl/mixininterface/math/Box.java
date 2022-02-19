package net.meshmc.mesh.impl.mixininterface.math;

import net.meshmc.mesh.MeshStatics;

/**
 * Provides a mesh interface for interfacing with a 3d box
 * @author Tigermouthbear 1/13/22
 */
public interface Box {
    static Box create(double x1, double y1, double z1, double x2, double y2, double z2) {
        return MeshStatics.createBox(x1, y1, z1, x2, y2, z2);
    }

    static Box create(BlockPos pos) {
        return create(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
    }

    static Box create(BlockPos pos1, BlockPos pos2) {
        return create(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ());
    }

    static Box create(Vec3d pos1, Vec3d pos2) {
        return create(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ());
    }

    double getMinX();

    double getMinY();

    double getMinZ();

    double getMaxX();

    double getMaxY();

    double getMaxZ();

    // TODO: HELPER FUNCTIONS
}
