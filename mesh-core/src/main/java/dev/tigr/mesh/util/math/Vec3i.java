package dev.tigr.mesh.util.math;

import com.google.common.base.MoreObjects;

/**
 * A 3d integer vector (X, Y, Z)
 */
public class Vec3i {
    private final int x;
    private final int y;
    private final int z;

    public Vec3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3i(double x, double y, double z) {
        this((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));
    }

    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Vec3i)) return false;

        Vec3i vec3i = (Vec3i) other;
        return vec3i.x == x && vec3i.y == y && vec3i.z == z;
    }

    public int hashCode() {
        return (y + z * 31) * 31 + x;
    }

    public int compareTo(Vec3i other) {
        if(y == other.y) return z == other.z ? x - other.x : z - other.z;
        else return y - other.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public Vec3i crossProduct(Vec3i vec) {
        return new Vec3i(y * vec.z - z * vec.y, z * vec.x - x * vec.z, x * vec.y - y * vec.x);
    }

    public double getDistance(int xIn, int yIn, int zIn) {
        double d0 = x - xIn;
        double d1 = y - yIn;
        double d2 = z - zIn;
        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
    }

    public double distanceSq(double toX, double toY, double toZ) {
        double d0 = (double) x - toX;
        double d1 = (double) y - toY;
        double d2 = (double) z - toZ;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double distanceSqToCenter(double xIn, double yIn, double zIn) {
        double d0 = (double) x + 0.5D - xIn;
        double d1 = (double) y + 0.5D - yIn;
        double d2 = (double) z + 0.5D - zIn;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double distanceSq(Vec3i to) {
        return this.distanceSq(to.x, to.y, to.z);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("x", x).add("y", y).add("z", z).toString();
    }
}
