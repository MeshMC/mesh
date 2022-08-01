package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.util.block.PistonPushReaction;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.entity.Stance;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.network.NetworkDirection;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.MovementType;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.NetworkState;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;

public class MCEnum {
    private static final DyeColor[] DYES = DyeColor.values();
    private static final Direction[] FACINGS = Direction.values();
    private static final Hand[] HANDS = Hand.values();
    private static final MovementType[] MOVEMENT_TYPES = MovementType.values();
    private static final PistonBehavior[] PISTON_BEHAVIORS = PistonBehavior.values();
    private static final EntityPose[] STANCES = EntityPose.values();
    private static final net.minecraft.util.Arm[] ARMS = net.minecraft.util.Arm.values();
    private static final NetworkSide[] NETWORK_SIDES = NetworkSide.values();
    private static final NetworkState[] NETWORK_STATES = net.minecraft.network.NetworkState.values();

    public static DyeColor dyeColor(net.meshmc.mesh.util.item.DyeColor dyeColor) {
        return DYES[dyeColor.ordinal()];
    }

    public static Direction facing(Facing facing) {
        return FACINGS[facing.ordinal()];
    }

    public static Hand hand(net.meshmc.mesh.util.math.Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static MovementType moverType(MoverType moverType) {
        return MOVEMENT_TYPES[moverType.ordinal()];
    }

    public static PistonBehavior pistonReaction(PistonPushReaction pistonPushReaction) {
        return PISTON_BEHAVIORS[pistonPushReaction.ordinal()];
    }

    public static EntityPose stance(Stance stance) {
        return STANCES[stance.ordinal()];
    }

    public static net.minecraft.util.Arm arm(Arm arm) {
        return ARMS[arm.ordinal()];
    }

    public static NetworkSide networkDirection(NetworkDirection networkDirection) {
        return NETWORK_SIDES[networkDirection.ordinal()];
    }

    public static NetworkState networkState(net.meshmc.mesh.util.network.NetworkState networkState) {
        return NETWORK_STATES[networkState.ordinal()];
    }
}
