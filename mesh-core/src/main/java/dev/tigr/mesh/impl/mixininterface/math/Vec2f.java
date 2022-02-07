package dev.tigr.mesh.impl.mixininterface.math;

import dev.tigr.mesh.MeshStatics;

public interface Vec2f {
    static Vec2f create(float x, float y) {
        return MeshStatics.createVec2f(x, y);
    }

    float getX();
    float getY();
    void setX(float value);
    void setY(float value);

    default Vec3d toVec3d() {
        return Vec3d.create(getX(), getY(), 0);
    }

    default Vec3d toVec3dHorizontal() {
        return Vec3d.create(getX(), 0, getY());
    }
}
