package net.meshmc.mesh.util.math;

import net.meshmc.mesh.impl.mixininterface.math.Vec3i;

/**
    A direction in the 3d world
 // TODO: EXTEND CAPABILITIES OF THIS, MAYBE MOVE TO WRAPPER?
 */
public enum Facing {
    DOWN(Vec3i.create(0, -1, 0)),
    UP(Vec3i.create(0, 1, 0)),
    NORTH(Vec3i.create(0, 0, -1)),
    SOUTH(Vec3i.create(0, 0, 1)),
    WEST(Vec3i.create(-1, 0, 0)),
    EAST(Vec3i.create(1, 0, 0));

    public static Facing[] VALUES = Facing.values();

    private final Vec3i offset;

    Facing(Vec3i offset) {
        this.offset = offset;
    }

    public Vec3i getOffset() {
        return offset;
    }
}
