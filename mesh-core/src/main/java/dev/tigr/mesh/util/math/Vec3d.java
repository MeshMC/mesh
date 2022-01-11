package dev.tigr.mesh.util.math;

/**
 * A 3d double vector (X, Y, Z)
 */
public class Vec3d {
    private final double x;
    private final double y;
    private final double z;

    public Vec3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3d(Vec3i vector) {
        this(vector.getX(), vector.getY(), vector.getZ());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vec3d subtractReverse(Vec3d vec) {
        return new Vec3d(vec.x - x, vec.y - y, vec.z - z);
    }

    public Vec3d normalize() {
        double d0 = Math.sqrt(x * x + y * y + z * z);
        return d0 < 1.0E-4D ? new Vec3d(0, 0, 0) : new Vec3d(x / d0, y / d0, z / d0);
    }

    public double dotProduct(Vec3d vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    public Vec3d crossProduct(Vec3d vec) {
        return new Vec3d(y * vec.z - z * vec.y, z * vec.x - x * vec.z, x * vec.y - y * vec.x);
    }

    public Vec3d subtract(Vec3d vec) {
        return this.subtract(vec.x, vec.y, vec.z);
    }

    public Vec3d subtract(double x, double y, double z) {
        return add(-x, -y, -z);
    }

    public Vec3d add(Vec3d vec) {
        return add(vec.x, vec.y, vec.z);
    }

    public Vec3d add(double x, double y, double z) {
        return new Vec3d(this.x + x, this.y + y, this.z + z);
    }

    public double distanceTo(Vec3d vec) {
        double d0 = vec.x - x;
        double d1 = vec.y - y;
        double d2 = vec.z - z;
        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
    }

    public double squareDistanceTo(Vec3d vec) {
        double d0 = vec.x - x;
        double d1 = vec.y - y;
        double d2 = vec.z - z;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double squareDistanceTo(double xIn, double yIn, double zIn) {
        double d0 = xIn - x;
        double d1 = yIn - y;
        double d2 = zIn - z;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public Vec3d scale(double factor) {
        return new Vec3d(x * factor, y * factor, z * factor);
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Vec3d)) return false;

        Vec3d vec3d = (Vec3d) other;
        return Double.compare(x, vec3d.x) == 0 && Double.compare(y, vec3d.y) == 0 && Double.compare(z, vec3d.z) == 0;
    }

    public int hashCode() {
        long j = Double.doubleToLongBits(x);
        int i = (int) (j ^ j >>> 32);
        j = Double.doubleToLongBits(y);
        i = 31 * i + (int) (j ^ j >>> 32);
        j = Double.doubleToLongBits(z);
        i = 31 * i + (int) (j ^ j >>> 32);
        return i;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}

