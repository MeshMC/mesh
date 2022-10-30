package net.meshmc.mesh;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.math.*;
import net.meshmc.mesh.api.render.buffer.BufferBuilder;
import net.meshmc.mesh.api.util.LocationIdentifier;

/**
 * CALLS TO THIS SHOULD ONLY BE USED IN MESH IMPLEMENTATIONS, IT IS NOT PRESENT IN mesh-core builds
 *
 * This file holds static minecraft methods and constructors for mesh.
 * The class is implemented by every mesh impl and should have version specific code in it
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session createSession(String username, String uuid, String accessToken, String type) {
        throw new RuntimeException();
    }

    public static Box createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        throw new RuntimeException();
    }

    public static Vec2f createVec2f(float x, float y) {
        throw new RuntimeException();
    }

    public static Vec3d createVec3d(double x, double y, double z) {
        throw new RuntimeException();
    }

    public static Vec3f createVec3f(float x, float y, float z) {
        throw new RuntimeException();
    }

    public static Vec3i createVec3i(int x, int y, int z) {
        throw new RuntimeException();
    }

    public static BlockPos createBlockPos(int x, int y, int z) {
        throw new RuntimeException();
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        throw new RuntimeException();
    }

    public static LocationIdentifier createLocationIdentifier(String namespace, String path) {
        throw new RuntimeException();
    }

    public static LocationIdentifier createLocationIdentifier(String path) {
        throw new RuntimeException();
    }

    public static Material createMaterial(MapColor mapColor) {
        throw new RuntimeException();
    }

    // TODO: CHANGE THE WAY SCREENS ARE HANDLED!!
    public static void openChatScreen(String input) {
        throw new RuntimeException();
    }

    public static void openDemoScreen() {
        throw new RuntimeException();
    }

    public static void openMultiplayerScreen() {
        throw new RuntimeException();
    }

    public static void openOptionsScreen() {
        throw new RuntimeException();
    }

    public static void openSelectWorldScreen() {
        throw new RuntimeException();
    }

    public static void openRealmsMainScreen() {
        throw new RuntimeException();
    }

    public static void openTitleScreen() {
        throw new RuntimeException();
    }
}
