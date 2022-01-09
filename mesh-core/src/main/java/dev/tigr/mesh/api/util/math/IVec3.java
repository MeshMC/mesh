package dev.tigr.mesh.api.util.math;

import java.util.Objects;

/**
 * Interface for all Vec3 objects
 *
 * @author Makrennel 2022/01/09
 */
public interface IVec3<T extends Number> {
    default boolean equals(IVec3<T> vec3) {
        return Objects.equals(this.getX(), vec3.getX())
                && Objects.equals(this.getY(), vec3.getY())
                && Objects.equals(this.getZ(), vec3.getZ());
    }

    Object getObject();

    boolean equalsObject(Object obj);

    default boolean isWrapper() {
        return true;
    }

    T getX();
    T getY();
    T getZ();

    IVec3<T> setX(T x);
    IVec3<T> setY(T y);
    IVec3<T> setZ(T z);

    default IVec3<T> setXZ(T x, T z) {
        return this
                .setX(x)
                .setZ(z);
    }

    default IVec3<T> setXZ(IVec2<T> vec2) {
        return this
                .setX(vec2.getA())
                .setZ(vec2.getB());
    }

    default IVec3<T> set(T x, T y, T z) {
        return this
                .setX(x)
                .setY(y)
                .setZ(z);
    }

    default IVec3<T> set(IVec3<T> vec3) {
        return this
                .setX(vec3.getX())
                .setY(vec3.getY())
                .setZ(vec3.getZ());
    }
}
