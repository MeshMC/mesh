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
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.*;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.util.hit.BlockHitResult;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StaticPackets {
    // C2S
    // Chat Message
    public static CPacketChatMessage createCPacketChatMessage(String message) {
        throw new RuntimeException("createCPacketChatMessage Not Yet Implemented");
//        return new CPacketChatMessageMesh(new ChatMessageC2SPacket(message));
    }

    public static CPacketChatMessage createCPacketChatMessage(ByteBuf buf) {
        return new CPacketChatMessageMesh(new ChatMessageC2SPacket(new PacketByteBuf(buf)));
    }

    // Confirm Teleport
    public static CPacketConfirmTeleport createCPacketConfirmTeleport(int id) {
        return new CPacketConfirmTeleportMesh(new TeleportConfirmC2SPacket(id));
    }

    public static CPacketConfirmTeleport createCPacketConfirmTeleport(ByteBuf buf) {
        return new CPacketConfirmTeleportMesh(new TeleportConfirmC2SPacket(new PacketByteBuf(buf)));
    }

    // Hand Swing
    public static CPacketHandSwing createCPacketHandSwing(Hand hand) {
        return new CPacketHandSwingMesh(new HandSwingC2SPacket(MCEnum.hand(hand)));
    }

    public static CPacketHandSwing createCPacketHandSwing(ByteBuf buf) {
        return new CPacketHandSwingMesh(new HandSwingC2SPacket(new PacketByteBuf(buf)));
    }

    // Input
    public static CPacketInput createCPacketInput(float sideways, float forward, boolean jumping, boolean sneaking) {
        return new CPacketInputMesh(new PlayerInputC2SPacket(sideways, forward, jumping, sneaking));
    }

    public static CPacketInput createCPacketInput(ByteBuf buf) {
        return new CPacketInputMesh(new PlayerInputC2SPacket(new PacketByteBuf(buf)));
    }

    // Movement
    public static CPacketMovePlayer.OnGround createCPacketMovePlayerOnGround(boolean onGround) {
        return new CPacketMovePlayerMesh.OnGround<>(new PlayerMoveC2SPacket.OnGroundOnly(onGround));
    }

    public static CPacketMovePlayer.OnGround createCPacketMovePlayerOnGround(ByteBuf buf) {
        return new CPacketMovePlayerMesh.OnGround<>(PlayerMoveC2SPacket.OnGroundOnly.read(new PacketByteBuf(buf)));
    }

    public static CPacketMovePlayer.Position createCPacketMovePlayerPosition(double x, double y, double z, boolean onGround) {
        return new CPacketMovePlayerMesh.Position(new PlayerMoveC2SPacket.PositionAndOnGround(x, y, z, onGround));
    }

    public static CPacketMovePlayer.Position createCPacketMovePlayerPosition(ByteBuf buf) {
        return new CPacketMovePlayerMesh.Position(PlayerMoveC2SPacket.PositionAndOnGround.read(new PacketByteBuf(buf)));
    }

    public static CPacketMovePlayer.Rotation createCPacketMovePlayerRotation(float yaw, float pitch, boolean onGround) {
        return new CPacketMovePlayerMesh.Rotation(new PlayerMoveC2SPacket.LookAndOnGround(yaw, pitch, onGround));
    }

    public static CPacketMovePlayer.Rotation createCPacketMovePlayerRotation(ByteBuf buf) {
        return new CPacketMovePlayerMesh.Rotation(PlayerMoveC2SPacket.LookAndOnGround.read(new PacketByteBuf(buf)));
    }

    public static CPacketMovePlayer.PositionRotation createCPacketMovePlayerPositionRotation(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        return new CPacketMovePlayerMesh.PositionRotation(new PlayerMoveC2SPacket.Full(x, y, z, yaw, pitch, onGround));
    }

    public static CPacketMovePlayer.PositionRotation createCPacketMovePlayerPositionRotation(ByteBuf buf) {
        return new CPacketMovePlayerMesh.PositionRotation(PlayerMoveC2SPacket.Full.read(new PacketByteBuf(buf)));
    }

    // Move Vehicle
    public static CPacketMoveVehicle createCPacketMoveVehicle(Entity entity) {
        return new CPacketMoveVehicleMesh(new VehicleMoveC2SPacket((net.minecraft.entity.Entity) entity));
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(double x, double y, double z, float yaw, float pitch) {
        // kind of a hack
        PacketByteBuf packetByteBuf = new PacketByteBuf(Unpooled.buffer());
        packetByteBuf.writeDouble(x);
        packetByteBuf.writeDouble(y);
        packetByteBuf.writeDouble(z);
        packetByteBuf.writeFloat(yaw);
        packetByteBuf.writeFloat(pitch);
        return new CPacketMoveVehicleMesh(new VehicleMoveC2SPacket(packetByteBuf));
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(ByteBuf buf) {
        return new CPacketMoveVehicleMesh(new VehicleMoveC2SPacket(new PacketByteBuf(buf)));
    }

    // Steer Boat
    public static CPacketSteerBoat createCPacketSteerBoat(boolean left, boolean right) {
        return new CPacketSteerBoatMesh(new BoatPaddleStateC2SPacket(left, right));
    }

    public static CPacketSteerBoat createCPacketSteerBoat(ByteBuf buf) {
        return new CPacketSteerBoatMesh(new BoatPaddleStateC2SPacket(new PacketByteBuf(buf)));
    }

    // Use Block
    public static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock, int sequence) {
        return new CPacketUseBlockMesh(new PlayerInteractBlockC2SPacket(MCEnum.hand(hand), new BlockHitResult((net.minecraft.util.math.Vec3d) vector, MCEnum.facing(facing), (net.minecraft.util.math.BlockPos) blockPos, insideBlock), sequence));
    }

    public static CPacketUseBlock createCPacketUseBlock(ByteBuf buf) {
        return new CPacketUseBlockMesh(new PlayerInteractBlockC2SPacket(new PacketByteBuf(buf)));
    }

    // Use Entity
    public static CPacketUseEntity createCPacketUseEntityAttack(Entity entity, boolean sneaking) {
        return new CPacketUseEntityMesh(PlayerInteractEntityC2SPacket.attack((net.minecraft.entity.Entity) entity, sneaking));
    }

    public static CPacketUseEntity createCPacketUseEntityInteract(Entity entity, Hand hand, boolean sneaking) {
        return new CPacketUseEntityMesh(PlayerInteractEntityC2SPacket.interact((net.minecraft.entity.Entity) entity, sneaking, MCEnum.hand(hand)));
    }

    public static CPacketUseEntity createCPacketUseEntityInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        return new CPacketUseEntityMesh(PlayerInteractEntityC2SPacket.interactAt((net.minecraft.entity.Entity) entity, sneaking, MCEnum.hand(hand), (net.minecraft.util.math.Vec3d) pos));
    }

    public static CPacketUseEntity createCPacketUseEntity(ByteBuf buf) {
        return new CPacketUseEntityMesh(new PlayerInteractEntityC2SPacket(new PacketByteBuf(buf)));
    }

    // Use Item
    public static CPacketUseItem createCPacketUseItem(Hand hand, int sequence) {
        return new CPacketUseItemMesh(new PlayerInteractItemC2SPacket(MCEnum.hand(hand), sequence));
    }

    public static CPacketUseItem createCPacketUseItem(ByteBuf buf) {
        return new CPacketUseItemMesh(new PlayerInteractItemC2SPacket(new PacketByteBuf(buf)));
    }

    // S2C
    // Advancement Update
    public static SPacketAdvancementUpdate createSPacketAdvancementUpdate(boolean isFirstSync, Collection<Advancement> toAdd, Set<LocationIdentifier> toRemove, Map<LocationIdentifier, AdvancementProgress> progressUpdates) {
        return new SPacketAdvancementUpdateMesh(new AdvancementUpdateS2CPacket(isFirstSync, new CollectionWrapper<>(toAdd), new SetWrapper<>(toRemove), new MapWrapper<>(progressUpdates)));
    }

    public static SPacketAdvancementUpdate createSPacketAdvancementUpdate(ByteBuf buf) {
        return new SPacketAdvancementUpdateMesh(new AdvancementUpdateS2CPacket(new PacketByteBuf(buf)));
    }

    // Block Action
    public static SPacketBlockAction createSPacketBlockAction(BlockPos blockPos, Block block, @Nullable Enum<?> blockVariant, int instrument, int pitch) {
        // TODO: Derive Block from Combination of Block / BlockVariant
        throw new NotImplementedException("Creating SPacketBlockAction without ByteBuf is not yet implemented.");
//        return new SPacketBlockActionMesh(new BlockEventS2CPacket((net.minecraft.util.math.BlockPos) blockPos, block, instrument, pitch));
    }

    public static SPacketBlockAction createSPacketBlockAction(ByteBuf buf) {
        return new SPacketBlockActionMesh(new BlockEventS2CPacket(new PacketByteBuf(buf)));
    }

    // Block Update
    public static SPacketBlockUpdate createSPacketBlockUpdate(BlockPos blockPos, BlockState<?> blockState) {
        return new SPacketBlockUpdateMesh(new BlockUpdateS2CPacket((net.minecraft.util.math.BlockPos) blockPos, (net.minecraft.block.BlockState) blockState.getMeshValue()));
    }

    public static SPacketBlockUpdate createSPacketBlockUpdate(ByteBuf buf) {
        return new SPacketBlockUpdateMesh(new BlockUpdateS2CPacket(new PacketByteBuf(buf)));
    }

    // Break Progress
    public static SPacketBreakProgress createSPacketBreakProgress(int entityId, BlockPos blockPos, int progress) {
        return new SPacketBreakProgressMesh(new BlockBreakingProgressS2CPacket(entityId, (net.minecraft.util.math.BlockPos) blockPos, progress));
    }

    public static SPacketBreakProgress createSPacketBreakProgress(ByteBuf buf) {
        return new SPacketBreakProgressMesh(new BlockBreakingProgressS2CPacket(new PacketByteBuf(buf)));
    }

    // Player Position Rotation
    public static SPacketPlayerPositionRotation createSPacketPlayerPositionRotation(double x, double y, double z, float yaw, float pitch, Set<SPacketPlayerPositionRotation.Flag> flags, int teleportId, boolean shouldDismount) {
        Set<PositionFlag> flagSet = new HashSet<>();
        for(SPacketPlayerPositionRotation.Flag flag: flags) {
            flagSet.add(SPacketPlayerPositionRotationMesh.FLAGS[flag.ordinal()]);
        }
        return new SPacketPlayerPositionRotationMesh(new PlayerPositionLookS2CPacket(x, y, z, yaw, pitch, flagSet, teleportId));
    }

    public static SPacketPlayerPositionRotation createSPacketPlayerPositionRotation(ByteBuf buf) {
        return new SPacketPlayerPositionRotationMesh(new PlayerPositionLookS2CPacket(new PacketByteBuf(buf)));
    }

    // Tile Entity Update
    // TODO: BlockEntityType & NBT
//    public static SPacketTileEntityUpdate createSPacketTileEntityUpdate(BlockPos blockPos) {
//        throw new RuntimeException();
//    }

    public static SPacketTileEntityUpdate createSPacketTileEntityUpdate(ByteBuf buf) {
        return new SPacketTileEntityUpdateMesh(new BlockEntityUpdateS2CPacket(new PacketByteBuf(buf)));
    }
}
