package dev.tigr.mesh.impl.client.util.math;

import dev.tigr.mesh.api.util.math.IVec3;
import dev.tigr.mesh.impl.mixininterface.IVec3d;
import net.minecraft.util.math.Vec3d;

/**
 * Mesh API interface for wrapping minecraft's Vec3d class
 *
 * @author Makrennel 2022/01/09
 */
public class Vec3dMesh implements IVec3<Double> {
    Vec3d vec3d;

    private Vec3dMesh(Vec3d vec3d) {
        this.vec3d = vec3d;
    }

    public static Vec3dMesh wrap(Vec3d vec3d) {
        return new Vec3dMesh(vec3d);
    }

    public Vec3d get() {
        return vec3d;
    }

    @Override
    public Object getObject() {
        return vec3d;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return vec3d.equals(obj);
    }

    @Override
    public Double getX() {
        return vec3d.x;
    }

    @Override
    public Double getY() {
        return vec3d.y;
    }

    @Override
    public Double getZ() {
        return vec3d.z;
    }

    @Override
    public IVec3<Double> setX(Double x) {
        ((IVec3d) vec3d).setX(x);
        return this;
    }

    @Override
    public IVec3<Double> setY(Double y) {
        ((IVec3d) vec3d).setY(y);
        return this;
    }

    @Override
    public IVec3<Double> setZ(Double z) {
        ((IVec3d) vec3d).setZ(z);
        return this;
    }
}
