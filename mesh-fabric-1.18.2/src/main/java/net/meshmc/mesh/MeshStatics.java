package net.meshmc.mesh;

import io.netty.buffer.Unpooled;
import net.meshmc.mesh.api.block.MapColor;
import net.meshmc.mesh.api.block.Material;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.*;
import net.meshmc.mesh.api.packet.client.*;
import net.meshmc.mesh.api.render.BufferBuilder;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.meshmc.mesh.impl.wrapper.render.BufferBuilderMesh;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;

/**
 * @author Tigermouthbear 1/10/22
 */
public class MeshStatics {
    // types: legacy, mojang, msa (only on newer versions)
    public static Session createSession(String username, String uuid, String accessToken, String type) {
        return (Session) new net.minecraft.client.util.Session(username, uuid, accessToken, null, null, net.minecraft.client.util.Session.AccountType.byName(type));
    }

    public static Box createBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (Box) new net.minecraft.util.math.Box(x1, y1, z1, x2, y2, z2);
    }

    public static Vec2f createVec2f(float x, float y) {
        return (Vec2f) new net.minecraft.util.math.Vec2f(x, y);
    }

    public static Vec3d createVec3d(double x, double y, double z) {
        return (Vec3d) new net.minecraft.util.math.Vec3d(x, y, z);
    }

    public static Vec3f createVec3f(float x, float y, float z) {
        return (Vec3f) new net.minecraft.util.math.Vec3f(x, y, z);
    }

    public static Vec3i createVec3i(int x, int y, int z) {
        return (Vec3i) new net.minecraft.util.math.Vec3i(x, y, z);
    }

    public static BlockPos createBlockPos(int x, int y, int z) {
        return (BlockPos) new net.minecraft.util.math.BlockPos(x, y, z);
    }

    public static BufferBuilder<?> createBufferBuilder(int initialCapacity) {
        return new BufferBuilderMesh(new net.minecraft.client.render.BufferBuilder(initialCapacity));
    }

    public static LocationIdentifier createLocationIdentifier(String namespace, String path) {
        return (LocationIdentifier) new Identifier(namespace, path);
    }

    public static LocationIdentifier createLocationIdentifier(String path) {
        return (LocationIdentifier) new Identifier(path);
    }

    public static Material createMaterial(MapColor mapColor) {
        return (Material) new net.minecraft.block.Material.Builder((net.minecraft.block.MapColor) mapColor).build();
    }

    // packets
    public static CPacketInput createCPacketInput(float sideways, float forward, boolean jumping, boolean sneaking) {
        return (CPacketInput) new PlayerInputC2SPacket(sideways, forward, jumping, sneaking);
    }

    public static CPacketMovePlayer createCPacketMovePlayerOnGround(boolean onGround) {
        return (CPacketMovePlayer) new PlayerMoveC2SPacket.OnGroundOnly(onGround);
    }

    public static CPacketMovePlayer createCPacketMovePlayerMoving(double x, double y, double z, boolean onGround) {
        return (CPacketMovePlayer) new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, onGround);
    }

    public static CPacketMovePlayer createCPacketMovePlayerRotating(float yaw, float pitch, boolean onGround) {
        return (CPacketMovePlayer) new PlayerMoveC2SPacket.LookAndOnGround(yaw, pitch, onGround);
    }

    public static CPacketMovePlayer createCPacketMovePlayerFull(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        return (CPacketMovePlayer) new PlayerMoveC2SPacket.Full(x, y, z, yaw, pitch, onGround);
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(Entity entity) {
        return (CPacketMoveVehicle) new VehicleMoveC2SPacket(((EntityMesh<?>) entity).getMeshValue());
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(double x, double y, double z, float yaw, float pitch) {
        // kind of a hack
        PacketByteBuf packetByteBuf = new PacketByteBuf(Unpooled.buffer());
        packetByteBuf.writeDouble(x);
        packetByteBuf.writeDouble(y);
        packetByteBuf.writeDouble(z);
        packetByteBuf.writeFloat(yaw);
        packetByteBuf.writeFloat(pitch);
        return (CPacketMoveVehicle) new VehicleMoveC2SPacket(packetByteBuf);
    }

    public static CPacketSteerBoat createCPacketSteerBoat(boolean left, boolean right) {
        return (CPacketSteerBoat) new BoatPaddleStateC2SPacket(left, right);
    }

    public static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock) {
        return (CPacketUseBlock) new PlayerInteractBlockC2SPacket(MCEnum.hand(hand), new BlockHitResult((net.minecraft.util.math.Vec3d) vector.add(blockPos), MCEnum.facing(facing), (net.minecraft.util.math.BlockPos) blockPos, insideBlock));
    }

    public static CPacketUseEntity createCPacketUseEntityAttack(Entity entity, boolean sneaking) {
        return (CPacketUseEntity) PlayerInteractEntityC2SPacket.attack(((EntityMesh<?>) entity).getMeshValue(), sneaking);
    }

    public static CPacketUseEntity createCPacketUseEntityInteract(Entity entity, Hand hand, boolean sneaking) {
        return (CPacketUseEntity) PlayerInteractEntityC2SPacket.interact(((EntityMesh<?>) entity).getMeshValue(), sneaking, MCEnum.hand(hand));
    }

    public static CPacketUseEntity createCPacketUseEntityInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        return (CPacketUseEntity) PlayerInteractEntityC2SPacket.interactAt(((EntityMesh<?>) entity).getMeshValue(), sneaking, MCEnum.hand(hand), (net.minecraft.util.math.Vec3d) pos);
    }

    public static CPacketUseItem createCPacketUseItem(Hand hand) {
        return (CPacketUseItem) new PlayerInteractItemC2SPacket(MCEnum.hand(hand));
    }

    public static CPacketHandSwing createCPacketHandSwing(Hand hand) {
        return (CPacketHandSwing) new HandSwingC2SPacket(MCEnum.hand(hand));
    }

    public static CPacketChatMessage createCPacketChatMessage(String message) {
        return (CPacketChatMessage) new ChatMessageC2SPacket(message);
    }

    public static CPacketConfirmTeleport createCPacketConfirmTeleport(int id) {
        return (CPacketConfirmTeleport) new TeleportConfirmC2SPacket(id);
    }
}
