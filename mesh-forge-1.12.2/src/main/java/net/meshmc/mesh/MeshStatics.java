package net.meshmc.mesh;

import io.netty.buffer.Unpooled;
import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.*;
import net.meshmc.mesh.api.packet.client.CPacketChatMessage;
import net.meshmc.mesh.api.packet.client.CPacketConfirmTeleport;
import net.meshmc.mesh.api.packet.client.CPacketInput;
import net.meshmc.mesh.api.packet.client.CPacketSteerBoat;
import net.meshmc.mesh.api.packet.client.CPacketUseEntity;
import net.meshmc.mesh.api.packet.client.*;
import net.meshmc.mesh.api.render.BufferBuilder;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.wrapper.render.BufferBuilderMesh;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.util.vector.Vector3f;

import java.io.IOException;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session createSession(String username, String uuid, String accessToken, String type) {
        return (Session) new net.minecraft.util.Session(username, uuid, accessToken, type);
    }

    public static Box createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (Box) new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
    }

    public static Vec2f createVec2f(float x, float y) {
        return (Vec2f) new net.minecraft.util.math.Vec2f(x, y);
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

    public static LocationIdentifier createLocationIdentifier(String namespace, String path) {
        return (LocationIdentifier) new ResourceLocation(namespace, path);
    }

    public static LocationIdentifier createLocationIdentifier(String path) {
        return (LocationIdentifier) new ResourceLocation(path);
    }

    public static Material createMaterial(MapColor mapColor) {
        return (Material) new net.minecraft.block.material.Material((net.minecraft.block.material.MapColor) mapColor);
    }

    // packets
    public static CPacketInput createCPacketInput(float sideways, float forward, boolean jumping, boolean sneaking) {
        return (CPacketInput) new net.minecraft.network.play.client.CPacketInput(sideways, forward, jumping, sneaking);
    }

    public static CPacketMovePlayer createCPacketMovePlayerOnGround(boolean onGround) {
        return (CPacketMovePlayer) new CPacketPlayer(onGround);
    }

    public static CPacketMovePlayer createCPacketMovePlayerMoving(double x, double y, double z, boolean onGround) {
        return (CPacketMovePlayer) new CPacketPlayer.Position(x, y, z, onGround);
    }

    public static CPacketMovePlayer createCPacketMovePlayerRotating(float yaw, float pitch, boolean onGround) {
        return (CPacketMovePlayer) new CPacketPlayer.Rotation(yaw, pitch, onGround);
    }

    public static CPacketMovePlayer createCPacketMovePlayerFull(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        return (CPacketMovePlayer) new CPacketPlayer.PositionRotation(x, y, z, yaw, pitch, onGround);
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(Entity entity) {
        return (CPacketMoveVehicle) new CPacketVehicleMove((net.minecraft.entity.Entity) entity);
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(double x, double y, double z, float yaw, float pitch) {
        CPacketVehicleMove packet = new CPacketVehicleMove();

        PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
        packetBuffer.writeDouble(x);
        packetBuffer.writeDouble(y);
        packetBuffer.writeDouble(z);
        packetBuffer.writeFloat(yaw);
        packetBuffer.writeFloat(pitch);

        try {
            packet.readPacketData(packetBuffer);
        } catch(IOException ignored) {
        }

        return (CPacketMoveVehicle) packet;
    }

    public static CPacketSteerBoat createCPacketSteerBoat(boolean left, boolean right) {
        return (CPacketSteerBoat) new net.minecraft.network.play.client.CPacketSteerBoat(left, right);
    }

    public static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock) {
        return (CPacketUseBlock) new CPacketPlayerTryUseItemOnBlock((net.minecraft.util.math.BlockPos) blockPos, MCEnum.facing(facing), MCEnum.hand(hand), (float) vector.getX(), (float) vector.getY(), (float) vector.getZ());
    }

    public static CPacketUseEntity createCPacketUseEntityAttack(Entity entity, boolean sneaking) {
        return (CPacketUseEntity) new net.minecraft.network.play.client.CPacketUseEntity((net.minecraft.entity.Entity) entity);
    }

    public static CPacketUseEntity createCPacketUseEntityInteract(Entity entity, Hand hand, boolean sneaking) {
        return (CPacketUseEntity) new net.minecraft.network.play.client.CPacketUseEntity((net.minecraft.entity.Entity) entity, MCEnum.hand(hand));
    }

    public static CPacketUseEntity createCPacketUseEntityInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        return (CPacketUseEntity) new net.minecraft.network.play.client.CPacketUseEntity((net.minecraft.entity.Entity) entity, MCEnum.hand(hand), (net.minecraft.util.math.Vec3d) pos);
    }

    public static CPacketUseItem createCPacketUseItem(Hand hand) {
        return (CPacketUseItem) new CPacketPlayerTryUseItem(MCEnum.hand(hand));
    }

    public static CPacketHandSwing createCPacketHandSwing(Hand hand) {
        return (CPacketHandSwing) new CPacketAnimation(MCEnum.hand(hand));
    }

    public static CPacketChatMessage createCPacketChatMessage(String message) {
        return (CPacketChatMessage) new net.minecraft.network.play.client.CPacketChatMessage(message);
    }

    public static CPacketConfirmTeleport createCPacketConfirmTeleport(int id) {
        return (CPacketConfirmTeleport) new net.minecraft.network.play.client.CPacketConfirmTeleport(id);
    }
}
