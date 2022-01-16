package dev.tigr.mesh.api.math;

import dev.tigr.mesh.MeshStatics;
import dev.tigr.mesh.api.AbstractMesh;

/**
 * Provides a mesh interface for interfacing with a 3d floating point vector
 * @author Tigermouthbear 1/15/22
 */
public abstract class Vec3f<T> extends AbstractMesh<T> {
    public static final Vec3f<?> ZERO = create(0, 0, 0);

    public Vec3f(T value) {
        super(value);
    }

    public static Vec3f<?> create(float x, float y, float z) {
        return MeshStatics.createVec3f(x, y, z);
    }

    public static Vec3f<?> create(Vec3i<?> vec3i) {
        return create(vec3i.getX(), vec3i.getY(), vec3i.getZ());
    }

    public abstract float getX();

    public abstract float getY();

    public abstract float getZ();

    // helper functions below

    public Vec3f<?> subtractReverse(Vec3f<?> vec) {
        return create(vec.getX() - getX(), vec.getY() - getY(), vec.getZ() - getZ());
    }

    public Vec3f<?> normalize() {
        float d0 = (float) Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
        return d0 < 1.0E-4D ? ZERO : create(getX() / d0, getY() / d0, getZ() / d0);
    }

    public float dotProduct(Vec3f<?> vec) {
        return getX() * vec.getX() + getY() * vec.getY() + getZ() * vec.getZ();
    }

    public Vec3f<?> crossProduct(Vec3f<?> vec) {
        return create(getY() * vec.getZ() - getZ() * vec.getY(), getZ() * vec.getX() - getX() * vec.getZ(), getX() * vec.getY() - getY() * vec.getX());
    }

    public Vec3f<?> subtract(Vec3f<?> vec) {
        return subtract(vec.getX(), vec.getY(), vec.getZ());
    }

    public Vec3f<?> subtract(float x, float y, float z) {
        return add(-x, -y, -z);
    }

    public Vec3f<?> add(Vec3f<?> vec) {
        return add(vec.getX(), vec.getY(), vec.getZ());
    }

    public Vec3f<?> add(float x, float y, float z) {
        return create(getX() + x, getY() + y, getZ() + z);
    }

    public double distanceTo(Vec3f<?> vec) {
        float d0 = vec.getX() - getX();
        float d1 = vec.getY() - getY();
        float d2 = vec.getZ() - getZ();
        return Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
    }

    public float squareDistanceTo(Vec3f<?> vec) {
        float d0 = vec.getX() - getX();
        float d1 = vec.getY() - getY();
        float d2 = vec.getZ() - getZ();
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public float squareDistanceTo(float xIn, float yIn, float zIn) {
        float d0 = xIn - getX();
        float d1 = yIn - getY();
        float d2 = zIn - getZ();
        return d0 * d0 + d1 * d1 + d2 * d2;
    }

    public Vec3f<?> scale(float factor) {
        return create(getX() * factor, getY() * factor, getZ() * factor);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public float lengthSquared() {
        return getX() * getX() + getY() * getY() + getZ() * getZ();
    }

    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Vec3f)) return false;

        Vec3f<?> vec3d = (Vec3f<?>) other;
        return Float.compare(getX(), vec3d.getX()) == 0 && Float.compare(getY(), vec3d.getY()) == 0 && Float.compare(getZ(), vec3d.getZ()) == 0;
    }

    public int hashCode() {
        int i = Float.floatToIntBits(getX());
        i = 31 * i + Float.floatToIntBits(getY());
        i = 31 * i + Float.floatToIntBits(getZ());
        return i;
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
    }
}

