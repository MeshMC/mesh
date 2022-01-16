package dev.tigr.mesh.api.math;

import dev.tigr.mesh.MeshStatics;
import dev.tigr.mesh.api.AbstractMesh;

/**
 * Provides a mesh interface for interfacing with a 3d double vector
 * @author Tigermouthbear 1/13/22
 */
public abstract class Vec3d<T> extends AbstractMesh<T> {
    public static final Vec3d<?> ZERO = create(0, 0, 0);

    public Vec3d(T value) {
        super(value);
    }

    public static Vec3d<?> create(double x, double y, double z) {
        return MeshStatics.createVec3d(x, y, z);
    }

    public static Vec3d<?> create(Vec3i<?> vec3i) {
        return create(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    public abstract double getX();

    public abstract double getY();

    public abstract double getZ();

    // helper functions below

    public Vec3d<?> subtractReverse(Vec3d<?> vec) {
        return create(vec.getX() - getX(), vec.getY() - getY(), vec.getZ() - getZ());
    }

    public Vec3d<?> normalize() {
        double d0 = Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
        return d0 < 1.0E-4D ? ZERO : create(getX() / d0, getY() / d0, getZ() / d0);
    }

    public double dotProduct(Vec3d<?> vec) {
        return getX() * vec.getX() + getY() * vec.getY() + getZ() * vec.getZ();
    }

    public Vec3d<?> crossProduct(Vec3d<?> vec) {
        return create(getY() * vec.getZ() - getZ() * vec.getY(), getZ() * vec.getX() - getX() * vec.getZ(), getX() * vec.getY() - getY() * vec.getX());
    }

    public Vec3d<?> subtract(Vec3d<?> vec) {
        return subtract(vec.getX(), vec.getY(), vec.getZ());
    }

    public Vec3d<?> subtract(double x, double y, double z) {
        return add(-x, -y, -z);
    }

    public Vec3d<?> add(Vec3d<?> vec) {
        return add(vec.getX(), vec.getY(), vec.getZ());
    }

    public Vec3d<?> add(double x, double y, double z) {
        return create(getX() + x, getY() + y, getZ() + z);
    }

    public double distanceTo(Vec3d<?> vec) {
        double d0 = vec.getX() - getX();
        double d1 = vec.getY() - getY();
        double d2 = vec.getZ() - getZ();
        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
    }

    public double squareDistanceTo(Vec3d<?> vec) {
        double d0 = vec.getX() - getX();
        double d1 = vec.getY() - getY();
        double d2 = vec.getZ() - getZ();
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double squareDistanceTo(double xIn, double yIn, double zIn) {
        double d0 = xIn - getX();
        double d1 = yIn - getY();
        double d2 = zIn - getZ();
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public Vec3d<?> scale(double factor) {
        return create(getX() * factor, getY() * factor, getZ() * factor);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ();
    }

    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Vec3d)) return false;

        Vec3d<?> vec3d = (Vec3d<?>) other;
        return Double.compare(getX(), vec3d.getX()) == 0 && Double.compare(getY(), vec3d.getY()) == 0 && Double.compare(getZ(), vec3d.getZ()) == 0;
    }

    public int hashCode() {
        long j = Double.doubleToLongBits(getX());
        int i = (int) (j ^ j >>> 32);
        j = Double.doubleToLongBits(getY());
        i = 31 * i + (int) (j ^ j >>> 32);
        j = Double.doubleToLongBits(getZ());
        i = 31 * i + (int) (j ^ j >>> 32);
        return i;
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }
}

