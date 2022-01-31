package dev.tigr.mesh;

import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.impl.mixininterface.math.*;
import dev.tigr.mesh.impl.render.BufferBuilderMesh;
import dev.tigr.mesh.impl.util.SessionMesh;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.util.vector.Vector3f;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session<?> createSession(String username, String uuid, String accessToken, String type) {
        return new SessionMesh(new net.minecraft.util.Session(username, uuid, accessToken, type));
    }

    public static Box createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (Box) new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
    }

    public static Vec3d createVec3d(double x, double y, double z) {
        return (Vec3d) new net.minecraft.util.math.Vec3d(x, y, z);
    }

    public static Vec3f createVec3f(float x, float y, float z) {
        return (Vec3f) new Vector3f(x, y, z);
    }

    public static Vec3i createVec3i(int x, int y, int z) {
        return (Vec3i) new net.minecraft.util.math.Vec3i(x, y, z);
    }

    public static BlockPos createBlockPos(int x, int y, int z) {
        return (BlockPos) new net.minecraft.util.math.BlockPos(x, y, z);
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        return new BufferBuilderMesh(new net.minecraft.client.renderer.BufferBuilder(initialCapacity));
    }
}
