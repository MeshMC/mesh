package net.meshmc.mesh.statics;

import io.netty.buffer.ByteBuf;
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
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class StaticPackets {

    // C2S
    // Chat Message
    // TODO: 1.19
    public static CPacketChatMessage createCPacketChatMessage(String message) {
        throw new RuntimeException();
    }

    public static CPacketChatMessage createCPacketChatMessage(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Confirm Teleport
    public static CPacketConfirmTeleport createCPacketConfirmTeleport(int id) {
        throw new RuntimeException();
    }

    public static CPacketConfirmTeleport createCPacketConfirmTeleport(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Hand Swing
    public static CPacketHandSwing createCPacketHandSwing(Hand hand) {
        throw new RuntimeException();
    }

    public static CPacketHandSwing createCPacketHandSwing(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Input
    public static CPacketInput createCPacketInput(float sideways, float forward, boolean jumping, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketInput createCPacketInput(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Movement
    public static CPacketMovePlayer.OnGround createCPacketMovePlayerOnGround(boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.OnGround createCPacketMovePlayerOnGround(ByteBuf buf) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.Position createCPacketMovePlayerPosition(double x, double y, double z, boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.Position createCPacketMovePlayerPosition(ByteBuf buf) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.Rotation createCPacketMovePlayerRotation(float yaw, float pitch, boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.Rotation createCPacketMovePlayerRotation(ByteBuf buf) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.PositionRotation createCPacketMovePlayerPositionRotation(double x, double y, double z, float yaw, float pitch, boolean onGround) {
        throw new RuntimeException();
    }

    public static CPacketMovePlayer.PositionRotation createCPacketMovePlayerPositionRotation(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Move Vehicle
    public static CPacketMoveVehicle createCPacketMoveVehicle(Entity entity) {
        throw new RuntimeException();
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(double x, double y, double z, float yaw, float pitch) {
        throw new RuntimeException();
    }

    public static CPacketMoveVehicle createCPacketMoveVehicle(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Steer Boat
    public static CPacketSteerBoat createCPacketSteerBoat(boolean left, boolean right) {
        throw new RuntimeException();
    }

    public static CPacketSteerBoat createCPacketSteerBoat(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Use Block
    public static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock, int sequence) {
        throw new RuntimeException();
    }

    public static CPacketUseBlock createCPacketUseBlock(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Use Entity
    public static CPacketUseEntity createCPacketUseEntityAttack(Entity entity, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketUseEntity createCPacketUseEntityInteract(Entity entity, Hand hand, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketUseEntity createCPacketUseEntityInteractAt(Entity entity, Hand hand, Vec3d pos, boolean sneaking) {
        throw new RuntimeException();
    }

    public static CPacketUseEntity createCPacketUseEntity(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Use Item
    public static CPacketUseItem createCPacketUseItem(Hand hand, int sequence) {
        throw new RuntimeException();
    }

    public static CPacketUseItem createCPacketUseItem(ByteBuf buf) {
        throw new RuntimeException();
    }

    // S2C
    // Advancement Update
    public static SPacketAdvancementUpdate createSPacketAdvancementUpdate(boolean isFirstSync, Collection<Advancement> toAdd, Set<LocationIdentifier> toRemove, Map<LocationIdentifier, AdvancementProgress> progressUpdates) {
        throw new RuntimeException();
    }

    public static SPacketAdvancementUpdate createSPacketAdvancementUpdate(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Block Action
    public static SPacketBlockAction createSPacketBlockAction(BlockPos blockPos, Block block, @Nullable Enum<?> blockVariant, int instrument, int pitch) {
        throw new RuntimeException();
    }

    public static SPacketBlockAction createSPacketBlockAction(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Block Update
    public static SPacketBlockUpdate createSPacketBlockUpdate(BlockPos blockPos, BlockState<?> blockState) {
        throw new RuntimeException();
    }

    public static SPacketBlockUpdate createSPacketBlockUpdate(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Break Progress
    public static SPacketBreakProgress createSPacketBreakProgress(int entityId, BlockPos blockPos, int progress) {
        throw new RuntimeException();
    }

    public static SPacketBreakProgress createSPacketBreakProgress(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Player Position Rotation
    public static SPacketPlayerPositionRotation createSPacketPlayerPositionRotation(double x, double y, double z, float yaw, float pitch, Set<SPacketPlayerPositionRotation.Flag> flags, int teleportId, boolean shouldDismount) {
        throw new RuntimeException();
    }

    public static SPacketPlayerPositionRotation createSPacketPlayerPositionRotation(ByteBuf buf) {
        throw new RuntimeException();
    }

    // Tile Entity Update
    // TODO: BlockEntityType & NBT
//    public static SPacketTileEntityUpdate createSPacketTileEntityUpdate(BlockPos blockPos) {
//        throw new RuntimeException();
//    }

    public static SPacketTileEntityUpdate createSPacketTileEntityUpdate(ByteBuf buf) {
        throw new RuntimeException();
    }
}
