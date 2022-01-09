package dev.tigr.mesh.api.util.math;

import java.util.Objects;

/**
 * Interface for all Vec2 objects
 *
 * @author Makrennel 2022/01/09
 */
public interface IVec2<T extends Number> {
    default boolean equals(IVec2<T> vec2) {
        return Objects.equals(this.getA(), vec2.getA())
                && Objects.equals(this.getB(), vec2.getB());
    }

    Object getObject();

    boolean equalsObject(Object obj);

    default boolean isWrapper() {
        return true;
    }

    T getA();
    T getB();

    IVec2<T> setA(T a);
    IVec2<T> setB(T b);

    default IVec2<T> set(T a, T b) {
        return this
                .setA(a)
                .setB(b);
    }

    default IVec2<T> set(IVec2<T> vec2) {
        return this
                .setA(vec2.getA())
                .setB(vec2.getB());
    }
}
