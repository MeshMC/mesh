package dev.tigr.mesh.api.math;

import dev.tigr.mesh.MeshStatics;
import dev.tigr.mesh.api.AbstractMesh;

/**
 * Provides a mesh interface for interfacing with a 3d box
 * @author Tigermouthbear 1/13/22
 */
public abstract class Box<T> extends AbstractMesh<T> {
    public Box(T value) {
        super(value);
    }

    public static Box<?> create(double x1, double y1, double z1, double x2, double y2, double z2) {
        return MeshStatics.createBox(x1, y1, z1, x2, y2, z2);
    }

    public static Box<?> create(BlockPos<?> pos) {
        return create(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
    }

    public static Box<?> create(BlockPos<?> pos1, BlockPos<?> pos2) {
        return create(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ());
    }

    public static Box<?> create(Vec3d<?> pos1, Vec3d<?> pos2) {
        return create(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ());
    }

    public abstract double getMinX();

    public abstract double getMinY();

    public abstract double getMinZ();

    public abstract double getMaxX();

    public abstract double getMaxY();

    public abstract double getMaxZ();

    // TODO: HELPER FUNCTIONS
}
