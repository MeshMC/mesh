package dev.tigr.mesh.impl.client.util.math;

import dev.tigr.mesh.api.util.math.IVec3;
import dev.tigr.mesh.impl.mixininterface.IVec3i;
import net.minecraft.util.math.Vec3i;

/**
 * Mesh API interface for wrapping minecraft's Vec3i class
 *
 * @author Makrennel 2022/01/09
 */
public class Vec3iMesh implements IVec3<Integer> {
    Vec3i vec3i;

    private Vec3iMesh(Vec3i vec3i) {
        this.vec3i = vec3i;
    }

    public static Vec3iMesh wrap(Vec3i vec3i) {
        return new Vec3iMesh(vec3i);
    }

    public Vec3i get() {
        return vec3i;
    }

    @Override
    public Object getObject() {
        return vec3i;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return vec3i.equals(obj);
    }

    @Override
    public Integer getX() {
        return vec3i.getX();
    }

    @Override
    public Integer getY() {
        return vec3i.getY();
    }

    @Override
    public Integer getZ() {
        return vec3i.getZ();
    }

    @Override
    public IVec3<Integer> setX(Integer x) {
        ((IVec3i) vec3i).setX(x);
        return this;
    }

    @Override
    public IVec3<Integer> setY(Integer y) {
        ((IVec3i) vec3i).setY(y);
        return this;
    }

    @Override
    public IVec3<Integer> setZ(Integer z) {
        ((IVec3i) vec3i).setZ(z);
        return this;
    }
}
