package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.util.block.PistonPushReaction;
import net.meshmc.mesh.util.entity.ActionResult;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.item.DyeColor;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.meshmc.mesh.util.network.NetworkDirection;
import net.meshmc.mesh.util.network.NetworkState;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;

public class MeshEnum {
    private static final DyeColor[] DYES = DyeColor.values();
    private static final Facing[] FACINGS = Facing.values();
    private static final Hand[] HANDS = Hand.values();
    private static final MoverType[] MOVER_TYPES = MoverType.values();
    private static final PistonPushReaction[] PISTON_BEHAVIORS = PistonPushReaction.values();
    private static final ActionResult[] ACTION_RESULTS = ActionResult.values();
    private static final Arm[] ARMS = Arm.values();
    private static final NetworkDirection[] NETWORK_DIRECTIONS = NetworkDirection.values();
    private static final NetworkState[] NETWORK_STATES = NetworkState.values();

    public static DyeColor dyeColor(EnumDyeColor dyeColor) {
        return DYES[dyeColor.ordinal()];
    }

    public static Facing facing(EnumFacing facing) {
        return FACINGS[facing.ordinal()];
    }

    public static Hand hand(EnumHand hand) {
        return HANDS[hand.ordinal()];
    }

    public static MoverType moverType(net.minecraft.entity.MoverType movementType) {
        return MOVER_TYPES[movementType.ordinal()];
    }

    public static PistonPushReaction pistonReaction(EnumPushReaction pistonPushReaction) {
        return PISTON_BEHAVIORS[pistonPushReaction.ordinal()];
    }

    public static ActionResult actionResult(EnumActionResult actionResult) {
        return ACTION_RESULTS[actionResult.ordinal()];
    }

    public static Arm arm(EnumHandSide arm) {
        return ARMS[arm.ordinal()];
    }

    public static NetworkDirection networkDirection(EnumPacketDirection packetDirection) {
        return NETWORK_DIRECTIONS[packetDirection.ordinal()];
    }

    public static NetworkState networkState(EnumConnectionState connectionState) {
        return NETWORK_STATES[connectionState.ordinal()];
    }
}
