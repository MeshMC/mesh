package dev.tigr.mesh.api.math;

import dev.tigr.mesh.api.util.math.IVec2;

public class Vec2<T extends Number> implements IVec2<T> {
    public T a, b;

    public Vec2(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public Vec2(IVec2<T> vec2) {
        this.a = vec2.getA();
        this.b = vec2.getB();
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return equals(obj);
    }

    @Override
    public boolean isWrapper() {
        return false;
    }

    @Override
    public T getA() {
        return a;
    }

    @Override
    public T getB() {
        return b;
    }

    @Override
    public Vec2<T> setA(T a) {
        this.a = a;
        return this;
    }

    @Override
    public Vec2<T> setB(T b) {
        this.b = b;
        return this;
    }
}
