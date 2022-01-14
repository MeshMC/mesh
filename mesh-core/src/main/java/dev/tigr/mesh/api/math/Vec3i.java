package dev.tigr.mesh.api.math;

import dev.tigr.mesh.MeshStatics;
import dev.tigr.mesh.api.AbstractMesh;

/**
 * Provides a mesh interface for interfacing with a 3d integer vector
 * @author Tigermouthbear 1/13/22
 */
public abstract class Vec3i<T> extends AbstractMesh<T> {
    public Vec3i(T value) {
        super(value);
    }

    public static Vec3i<?> create(int x, int y, int z) {
        return MeshStatics.createVec3i(x, y, z);
    }

    public static Vec3i<?> create(double x, double y, double z) {
        return MeshStatics.createVec3i((int) Math.floor(x), (int) Math.floor(y), (int) Math.floor(z));
    }

    public static Vec3i<?> create(Vec3d<?> vec3d) {
        return create(vec3d.getX(), vec3d.getY(), vec3d.getZ());
    }

    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Vec3i)) return false;

        Vec3i<?> vec3i = (Vec3i<?>) other;
        return vec3i.getX() == getX() && vec3i.getY() == getY() && vec3i.getZ() == getZ();
    }

    public int hashCode() {
        return (getY() + getZ() * 31) * 31 + getX();
    }

    public int compareTo(Vec3i<?> other) {
        if(getY() == other.getY()) return getZ() == other.getZ() ? getX() - other.getX() : getZ() - other.getZ();
        else return getY() - other.getY();
    }

    public abstract int getX();

    public abstract int getY();

    public abstract int getZ();

    public Vec3i<?> crossProduct(Vec3i<?> vec) {
        return create(getY() * vec.getZ() - getZ() * vec.getY(), getZ() * vec.getX() - getX() * vec.getZ(), getX() * vec.getY() - getY() * vec.getX());
    }

    public double getDistance(int xIn, int yIn, int zIn) {
        double d0 = getX() - xIn;
        double d1 = getY() - yIn;
        double d2 = getZ() - zIn;
        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
    }

    public double distanceSq(double toX, double toY, double toZ) {
        double d0 = (double) getX() - toX;
        double d1 = (double) getY() - toY;
        double d2 = (double) getZ() - toZ;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double distanceSqToCenter(double xIn, double yIn, double zIn) {
        double d0 = (double) getX() + 0.5D - xIn;
        double d1 = (double) getY() + 0.5D - yIn;
        double d2 = (double) getZ() + 0.5D - zIn;
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public double distanceSq(Vec3i<?> to) {
        return distanceSq(to.getX(), to.getY(), to.getZ());
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }
}
