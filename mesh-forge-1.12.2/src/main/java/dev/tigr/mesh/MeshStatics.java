package dev.tigr.mesh;

import dev.tigr.mesh.api.math.*;
import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.impl.math.*;
import dev.tigr.mesh.impl.render.BufferBuilderMesh;
import dev.tigr.mesh.impl.util.SessionMesh;
import org.lwjgl.util.vector.Vector3f;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session<?> createSession(String username, String uuid, String accessToken, String type) {
        return new SessionMesh(new net.minecraft.util.Session(username, uuid, accessToken, type));
    }

    public static Box<?> createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        return new BoxMesh(new net.minecraft.util.math.AxisAlignedBB(x1, y1, z1, x2, y2, z2));
    }

    public static Vec3d<?> createVec3d(double x, double y, double z) {
        return new Vec3dMesh(new net.minecraft.util.math.Vec3d(x, y, z));
    }

    public static Vec3f<?> createVec3f(float x, float y, float z) {
        return new Vec3fMesh(new Vector3f(x, y, z));
    }

    public static Vec3i<?> createVec3i(int x, int y, int z) {
        return new Vec3iMesh(new net.minecraft.util.math.Vec3i(x, y, z));
    }

    public static BlockPos<?> createBlockPos(int x, int y, int z) {
        return new BlockPosMesh(new net.minecraft.util.math.BlockPos(x, y, z));
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        return new BufferBuilderMesh(new net.minecraft.client.renderer.BufferBuilder(initialCapacity));
    }
}
