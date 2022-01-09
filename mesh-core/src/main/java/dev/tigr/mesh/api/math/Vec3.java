package dev.tigr.mesh.api.math;

import dev.tigr.mesh.api.util.math.IVec3;

/**
 * Vec3 object for numerical data.
 *
 * @author Makrennel 2022/01/09
 */
public class Vec3<T extends Number> implements IVec3<T> {
    private T x, y, z;

    public Vec3(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(IVec3<T> vec3) {
        this.x = vec3.getX();
        this.y = vec3.getY();
        this.z = vec3.getZ();
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return this.equals(obj);
    }

    @Override
    public boolean isWrapper() {
        return false;
    }

    @Override
    public T getX() {
        return x;
    }

    @Override
    public T getY() {
        return y;
    }

    @Override
    public T getZ() {
        return z;
    }

    @Override
    public IVec3<T> setX(T x) {
        this.x = x;
        return this;
    }

    @Override
    public IVec3<T> setY(T y) {
        this.y = y;
        return this;
    }

    @Override
    public IVec3<T> setZ(T z) {
        this.z = z;
        return this;
    }
}
