package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.util.block.PistonPushReaction;
import net.meshmc.mesh.util.math.Facing;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;

public class MCEnum {
    private static final DyeColor[] DYES = DyeColor.values();
    private static final Direction[] FACINGS = Direction.values();
    private static final Hand[] HANDS = Hand.values();
    private static final PistonBehavior[] PISTON_BEHAVIORS = PistonBehavior.values();

    public static DyeColor dyeColor(net.meshmc.mesh.util.item.DyeColor dyeColor) {
        return DYES[dyeColor.ordinal()];
    }

    public static Direction facing(Facing facing) {
        return FACINGS[facing.ordinal()];
    }

    public static Hand hand(net.meshmc.mesh.util.math.Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static PistonBehavior pistonReaction(PistonPushReaction pistonPushReaction) {
        return PISTON_BEHAVIORS[pistonPushReaction.ordinal()];
    }
}
