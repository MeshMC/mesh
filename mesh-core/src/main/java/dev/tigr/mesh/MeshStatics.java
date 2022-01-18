package dev.tigr.mesh;

import dev.tigr.mesh.api.math.*;
import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.util.Session;

/**
 * CALLS TO THIS SHOULD ONLY BE USED IN MESH IMPLEMENTATIONS, IT IS NOT PRESENT IN mesh-core builds
 *
 * This file holds static minecraft methods and constructors for mesh.
 * The class is implemented by every mesh impl and should have version specific code in it
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session<?> createSession(String username, String uuid, String accessToken, String type) {
        throw new RuntimeException();
    }

    public static Box<?> createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        throw new RuntimeException();
    }

    public static Vec3d<?> createVec3d(double x, double y, double z) {
        throw new RuntimeException();
    }

    public static Vec3f<?> createVec3f(float x, float y, float z) {
        throw new RuntimeException();
    }

    public static Vec3i<?> createVec3i(int x, int y, int z) {
        throw new RuntimeException();
    }

    public static BlockPos<?> createBlockPos(int x, int y, int z) {
        throw new RuntimeException();
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        throw new RuntimeException();
    }
}
