package net.meshmc.mesh.statics;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.meshmc.mesh.api.advancement.Advancement;
import net.meshmc.mesh.api.advancement.AdvancementProgress;
import net.meshmc.mesh.api.block.Block;
import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.client.*;
import net.meshmc.mesh.api.network.client.CPacketChatMessage;
import net.meshmc.mesh.api.network.client.CPacketConfirmTeleport;
import net.meshmc.mesh.api.network.client.CPacketInput;
import net.meshmc.mesh.api.network.client.CPacketSteerBoat;
import net.meshmc.mesh.api.network.client.CPacketUseEntity;
import net.meshmc.mesh.api.network.server.*;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.wrapper.network.client.*;
import net.meshmc.mesh.impl.wrapper.network.server.*;
import net.meshmc.mesh.util.collections.CollectionWrapper;
import net.meshmc.mesh.util.collections.MapWrapper;
import net.meshmc.mesh.util.collections.SetWrapper;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.*;
import net.minecraft.network.play.server.SPacketAdvancementInfo;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import org.apache.commons.lang3.NotImplementedException;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StaticPackets {
    // C2S
    // Chat Message
    public static CPacketChatMessage createCPacketChatMessage(String message) {
        return new CPacketChatMessageMesh(new net.minecraft.network.play.client.CPacketChatMessage(message));
    }

    public static CPacketChatMessage createCPacketChatMessage(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketChatMessage packet = new net.minecraft.network.play.client.CPacketChatMessage();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketChatMessageMesh(packet);
    }

    // Confirm Teleport
    public static CPacketConfirmTeleport createCPacketConfirmTeleport(int id) {
        return new CPacketConfirmTeleportMesh(new net.minecraft.network.play.client.CPacketConfirmTeleport(id));
    }

    public static CPacketConfirmTeleport createCPacketConfirmTeleport(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketConfirmTeleport packet = new net.minecraft.network.play.client.CPacketConfirmTeleport();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketConfirmTeleportMesh(packet);
    }

    // Hand Swing
    public static CPacketHandSwing createCPacketHandSwing(Hand hand) {
        return new CPacketHandSwingMesh(new CPacketAnimation(MCEnum.hand(hand)));
    }

    public static CPacketHandSwing createCPacketHandSwing(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketAnimation packet = new net.minecraft.network.play.client.CPacketAnimation();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketHandSwingMesh(packet);
    }

    // Input
    public static CPacketInput createCPacketInput(float sideways, float forward, boolean jumping, boolean sneaking) {
        return new CPacketInputMesh(new net.minecraft.network.play.client.CPacketInput(sideways, forward, jumping, sneaking));
    }

    public static CPacketInput createCPacketInput(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketInput packet = new net.minecraft.network.play.client.CPacketInput();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketInputMesh(packet);
    }

    // Movement
    public static CPacketMovePlayer.OnGround createCPacketMovePlayerOnGround(boolean onGround) {
        return new CPacketMovePlayerMesh.OnGround<>(new CPacketPlayer(onGround));
    }

    public static CPacketMovePlayer.OnGround createCPacketMovePlayerOnGround(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketPlayer packet = new net.minecraft.network.play.client.CPacketPlayer();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketMovePlayerMesh.OnGround<>(packet);
    }

    public static CPacketMovePlayer.Position createCPacketMovePlayerPosition(double x, double y, double z, boolean onGround) {
        return new CPacketMovePlayerMesh.Position(new CPacketPlayer.Position(x, y, z, onGround));
    }

    public static CPacketMovePlayer.Position createCPacketMovePlayerPosition(ByteBuf buf) {
        CPacketPlayer.Position packet = new CPacketPlayer.Position();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketMovePlayerMesh.Position(packet);
    }

    public static CPacketMovePlayer.Rotation createCPacketMovePlayerRotation(float yaw, float pitch, boolean onGround) {
        return new CPacketMovePlayerMesh.Rotation(new CPacketPlayer.Rotation(yaw, pitch, onGround));
    }

    public static CPacketMovePlayer.Rotation createCPacketMovePlayerRotation(ByteBuf buf) {
        CPacketPlayer.Rotation packet = new CPacketPlayer.Rotation();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketMovePlayerMesh.Rotation(packet);
    }

    public static CPacketMovePlayer.PositionRotation createCPacketMovePlayerPositionRotation(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        return new CPacketMovePlayerMesh.PositionRotation(new CPacketPlayer.PositionRotation(x, y, z, yaw, pitch, onGround));
    }

    public static CPacketMovePlayer.PositionRotation createCPacketMovePlayerPositionRotation(ByteBuf buf) {
        CPacketPlayer.PositionRotation packet = new CPacketPlayer.PositionRotation();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketMovePlayerMesh.PositionRotation(packet);
    }

    // Move Vehicle
    public static CPacketMoveVehicle createCPacketMoveVehicle(Entity entity) {
        return new CPacketMoveVehicleMesh(new CPacketVehicleMove((net.minecraft.entity.Entity) entity));
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
        } catch(IOException ignored) {}

        return new CPacketMoveVehicleMesh(packet);
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketVehicleMove packet = new net.minecraft.network.play.client.CPacketVehicleMove();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketMoveVehicleMesh(packet);
    }

    // Steer Boat
    public static CPacketSteerBoat createCPacketSteerBoat(boolean left, boolean right) {
        return new CPacketSteerBoatMesh(new net.minecraft.network.play.client.CPacketSteerBoat(left, right));
    }

    public static CPacketSteerBoat createCPacketSteerBoat(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketSteerBoat packet = new net.minecraft.network.play.client.CPacketSteerBoat();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketSteerBoatMesh(packet);
    }

    // Use Block
    public static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock) {
        return new CPacketUseBlockMesh(new CPacketPlayerTryUseItemOnBlock((net.minecraft.util.math.BlockPos) blockPos, MCEnum.facing(facing), MCEnum.hand(hand), (float) vector.getX(), (float) vector.getY(), (float) vector.getZ()));
    }

    public static CPacketUseBlock createCPacketUseBlock(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock packet = new net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketUseBlockMesh(packet);
    }

    // Use Entity
    public static CPacketUseEntity createCPacketUseEntityAttack(Entity entity, boolean sneaking) {
        return new CPacketUseEntityMesh(new net.minecraft.network.play.client.CPacketUseEntity((net.minecraft.entity.Entity) entity));
    }

    public static CPacketUseEntity createCPacketUseEntityInteract(Entity entity, Hand hand, boolean sneaking) {
        return new CPacketUseEntityMesh(new net.minecraft.network.play.client.CPacketUseEntity((net.minecraft.entity.Entity) entity, MCEnum.hand(hand)));
    }

    public static CPacketUseEntity createCPacketUseEntityInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        return new CPacketUseEntityMesh(new net.minecraft.network.play.client.CPacketUseEntity((net.minecraft.entity.Entity) entity, MCEnum.hand(hand), (net.minecraft.util.math.Vec3d) pos));
    }

    public static CPacketUseEntity createCPacketUseEntity(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketUseEntity packet = new net.minecraft.network.play.client.CPacketUseEntity();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketUseEntityMesh(packet);
    }

    // Use Item
    public static CPacketUseItem createCPacketUseItem(Hand hand) {
        return new CPacketUseItemMesh(new CPacketPlayerTryUseItem(MCEnum.hand(hand)));
    }

    public static CPacketUseItem createCPacketUseItem(ByteBuf buf) {
        net.minecraft.network.play.client.CPacketPlayerTryUseItem packet = new net.minecraft.network.play.client.CPacketPlayerTryUseItem();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new CPacketUseItemMesh(packet);
    }

    // S2C
    // Advancement Update
    public static SPacketAdvancementUpdate createSPacketAdvancementUpdate(boolean isFirstSync, Collection<Advancement> toAdd, Set<LocationIdentifier> toRemove, Map<LocationIdentifier, AdvancementProgress> progressUpdates) {
        return new SPacketAdvancementUpdateMesh(new SPacketAdvancementInfo(isFirstSync, new CollectionWrapper<>(toAdd), new SetWrapper<>(toRemove), new MapWrapper<>(progressUpdates)));
    }

    public static SPacketAdvancementUpdate createSPacketAdvancementUpdate(ByteBuf buf) {
        net.minecraft.network.play.server.SPacketAdvancementInfo packet = new net.minecraft.network.play.server.SPacketAdvancementInfo();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new SPacketAdvancementUpdateMesh(packet);
    }

    // Block Action
    public static SPacketBlockAction createSPacketBlockAction(BlockPos blockPos, Block block, @Nullable Enum<?> blockVariant, int instrument, int pitch) {
        // TODO: Derive Block from Combination of Block / BlockVariant
        throw new NotImplementedException("Creating SPacketBlockAction without ByteBuf is not yet implemented.");
//        return new SPacketBlockActionMesh(new BlockEventS2CPacket((net.minecraft.util.math.BlockPos) blockPos, block, instrument, pitch));
    }

    public static SPacketBlockAction createSPacketBlockAction(ByteBuf buf) {
        net.minecraft.network.play.server.SPacketBlockAction packet = new net.minecraft.network.play.server.SPacketBlockAction();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new SPacketBlockActionMesh(packet);
    }

    // Block Update
    public static SPacketBlockUpdate createSPacketBlockUpdate(BlockPos blockPos, BlockState<?> blockState) {
        SPacketBlockChange packet = new SPacketBlockChange();
        PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());

        packetBuffer.writeBlockPos((net.minecraft.util.math.BlockPos) blockPos);
        packetBuffer.writeVarInt(net.minecraft.block.Block.BLOCK_STATE_IDS.get((IBlockState) blockState));

        try {
            packet.readPacketData(packetBuffer);
        } catch(IOException ignored) {}

        return new SPacketBlockUpdateMesh(packet);
    }

    public static SPacketBlockUpdate createSPacketBlockUpdate(ByteBuf buf) {
        net.minecraft.network.play.server.SPacketBlockChange packet = new net.minecraft.network.play.server.SPacketBlockChange();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new SPacketBlockUpdateMesh(packet);
    }

    // Break Progress
    public static SPacketBreakProgress createSPacketBreakProgress(int entityId, BlockPos blockPos, int progress) {
        return new SPacketBreakProgressMesh(new SPacketBlockBreakAnim(entityId, (net.minecraft.util.math.BlockPos) blockPos, progress));
    }

    public static SPacketBreakProgress createSPacketBreakProgress(ByteBuf buf) {
        net.minecraft.network.play.server.SPacketBlockBreakAnim packet = new net.minecraft.network.play.server.SPacketBlockBreakAnim();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new SPacketBreakProgressMesh(packet);
    }

    // Player Position Rotation
    public static SPacketPlayerPositionRotation createSPacketPlayerPositionRotation(double x, double y, double z, float yaw, float pitch, Set<SPacketPlayerPositionRotation.Flag> flags, int teleportId, boolean shouldDismount) {
        Set<SPacketPlayerPosLook.EnumFlags> flagSet = new HashSet<>();
        for(SPacketPlayerPositionRotation.Flag flag: flags) {
            flagSet.add(SPacketPlayerPositionRotationMesh.FLAGS[flag.ordinal()]);
        }
        return new SPacketPlayerPositionRotationMesh(new SPacketPlayerPosLook(x, y, z, yaw, pitch, flagSet, teleportId));
    }

    public static SPacketPlayerPositionRotation createSPacketPlayerPositionRotation(ByteBuf buf) {
        net.minecraft.network.play.server.SPacketPlayerPosLook packet = new net.minecraft.network.play.server.SPacketPlayerPosLook();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new SPacketPlayerPositionRotationMesh(packet);
    }

    // Tile Entity Update
    // TODO: BlockEntityType & NBT
//    public static SPacketTileEntityUpdate createSPacketTileEntityUpdate(BlockPos blockPos) {
//        throw new RuntimeException();
//    }

    public static SPacketTileEntityUpdate createSPacketTileEntityUpdate(ByteBuf buf) {
        net.minecraft.network.play.server.SPacketUpdateTileEntity packet = new net.minecraft.network.play.server.SPacketUpdateTileEntity();
        try {packet.readPacketData(new PacketBuffer(buf));} catch(IOException ignored) {}
        return new SPacketTileEntityUpdateMesh(packet);
    }
}
