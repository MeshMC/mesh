package net.meshmc.mesh;

import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.*;
import net.meshmc.mesh.api.packet.client.*;
import net.meshmc.mesh.api.render.BufferBuilder;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;

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

    // packets
    public static CPacketInput createCPacketInput(float sideways, float forward, boolean jumping, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer createCPacketMovePlayerOnGround(boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer createCPacketMovePlayerMoving(double x, double y, double z, boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer createCPacketMovePlayerRotating(float yaw, float pitch, boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer createCPacketMovePlayerFull(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(Entity entity) {
        throw new RuntimeException();
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(double x, double y, double z, float yaw, float pitch) {
        throw new RuntimeException();
    }

    public static CPacketSteerBoat createCPacketSteerBoat(boolean left, boolean right) {
        throw new RuntimeException();
    }

    public static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock) {
        throw new RuntimeException();
    }

    public static CPacketUseEntity createCPacketUseEntityAttack(Entity entity, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketUseEntity createCPacketUseEntityInteract(Entity entity, Hand hand, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketUseEntity createCPacketUseEntityInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketUseItem createCPacketUseItem(Hand hand) {
        throw new RuntimeException();
    }

    public static CPacketHandSwing createCPacketHandSwing(Hand hand) {
        throw new RuntimeException();
    }

    public static CPacketChatMessage createCPacketChatMessage(String message) {
        throw new RuntimeException();
    }

    public static CPacketConfirmTeleport createCPacketConfirmTeleport(int id) {
        throw new RuntimeException();
    }
}
