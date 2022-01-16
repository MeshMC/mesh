package dev.tigr.mesh.impl.math;

import dev.tigr.mesh.api.math.Vec3f;
import org.lwjgl.util.vector.Vector3f;

/**
 * @author Tigermouthbear 1/15/22
 */
// this version has no vec3f equivalent, so we use lwjgl's
public class Vec3fMesh extends Vec3f<Vector3f> {
    public Vec3fMesh(Vector3f value) {
        super(value);
    }

    @Override
    public float getX() {
        return getMeshValue().getX();
    }

    @Override
    public float getY() {
        return getMeshValue().getY();
    }

    @Override
    public float getZ() {
        return getMeshValue().getZ();
    }
}
