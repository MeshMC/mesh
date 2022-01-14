package dev.tigr.mesh.api.math;

import dev.tigr.mesh.MeshStatics;
import dev.tigr.mesh.util.math.Facing;

/**
 * Represents a block in a position in the minecraft world
 */
public abstract class BlockPos<T> extends Vec3i<T> {
    public BlockPos(T value) {
        super(value);
    }

    public static BlockPos<?> create(int x, int y, int z) {
        return MeshStatics.createBlockPos(x, y, z);
    }

    public static BlockPos<?> create(double x, double y, double z) {
        return create((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));
    }

    public static BlockPos<?> create(Vec3d<?> vec) {
        return create(vec.getX(), vec.getY(), vec.getZ());
    }

    public static BlockPos<?> create(Vec3i<?> source) {
        return create(source.getX(), source.getY(), source.getZ());
    }

    public BlockPos<?> add(double x, double y, double z) {
        return x == 0.0D && y == 0.0D && z == 0.0D ? this : create((double) this.getX() + x, (double) this.getY() + y, (double) this.getZ() + z);
    }

    public BlockPos<?> add(int x, int y, int z) {
        return x == 0 && y == 0 && z == 0 ? this : create(this.getX() + x, this.getY() + y, this.getZ() + z);
    }

    public BlockPos<?> add(Vec3i<?> vec) {
        return this.add(vec.getX(), vec.getY(), vec.getZ());
    }

    public BlockPos<?> subtract(Vec3i<?> vec) {
        return this.add(-vec.getX(), -vec.getY(), -vec.getZ());
    }

    public BlockPos<?> up() {
        return this.up(1);
    }

    public BlockPos<?> up(int n) {
        return this.offset(Facing.UP, n);
    }

    public BlockPos<?> down() {
        return this.down(1);
    }

    public BlockPos<?> down(int n) {
        return this.offset(Facing.DOWN, n);
    }

    public BlockPos<?> north() {
        return this.north(1);
    }

    public BlockPos<?> north(int n) {
        return this.offset(Facing.NORTH, n);
    }

    public BlockPos<?> south() {
        return this.south(1);
    }

    public BlockPos<?> south(int n) {
        return this.offset(Facing.SOUTH, n);
    }

    public BlockPos<?> west() {
        return this.west(1);
    }

    public BlockPos<?> west(int n) {
        return this.offset(Facing.WEST, n);
    }

    public BlockPos<?> east() {
        return this.east(1);
    }

    public BlockPos<?> east(int n) {
        return this.offset(Facing.EAST, n);
    }

    public BlockPos<?> offset(Facing facing) {
        return this.offset(facing, 1);
    }

    public BlockPos<?> offset(Facing facing, int n) {
        return n == 0 ? this : create(this.getX() + facing.getOffset().getX() * n, this.getY() + facing.getOffset().getY() * n, this.getZ() + facing.getOffset().getZ() * n);
    }
}
