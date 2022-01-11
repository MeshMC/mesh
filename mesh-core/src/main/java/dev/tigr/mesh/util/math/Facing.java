package dev.tigr.mesh.util.math;

/**
    A direction in the 3d world
 */
public enum Facing {
    DOWN(new Vec3i(0, -1, 0)),
    UP(new Vec3i(0, 1, 0)),
    NORTH(new Vec3i(0, 0, -1)),
    SOUTH(new Vec3i(0, 0, 1)),
    WEST(new Vec3i(-1, 0, 0)),
    EAST(new Vec3i(1, 0, 0));

    private final Vec3i offset;

    Facing(Vec3i offset) {
        this.offset = offset;
    }

    public Vec3i getOffset() {
        return offset;
    }
}
