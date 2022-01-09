package dev.tigr.mesh.impl.client.util.math;

import dev.tigr.mesh.api.util.math.IVec2;
import dev.tigr.mesh.impl.mixin.accessors.Vec2fAccessor;
import net.minecraft.util.math.Vec2f;

/**
 * Mesh API interface for wrapping minecraft's Vec2f class
 *
 * @author Makrennel 2022/01/09
 */
public class Vec2fMesh implements IVec2<Float> {
    Vec2f vec2f;

    private Vec2fMesh(Vec2f vec2f) {
        this.vec2f = vec2f;
    }

    public static Vec2fMesh wrap(Vec2f vec2f) {
        return new Vec2fMesh(vec2f);
    }

    public Vec2f get() {
        return vec2f;
    }

    @Override
    public Object getObject() {
        return vec2f;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return vec2f.equals(obj);
    }

    @Override
    public Float getA() {
        return vec2f.x;
    }

    @Override
    public Float getB() {
        return vec2f.y;
    }

    @Override
    public IVec2<Float> setA(Float a) {
        ((Vec2fAccessor) vec2f).setX(a);
        return this;
    }

    @Override
    public IVec2<Float> setB(Float b) {
        ((Vec2fAccessor) vec2f).setY(b);
        return this;
    }
}
