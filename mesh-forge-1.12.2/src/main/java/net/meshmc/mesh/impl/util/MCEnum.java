package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.util.block.PistonPushReaction;
import net.meshmc.mesh.util.item.DyeColor;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;

public class MCEnum {
    private static final EnumDyeColor[] DYES = EnumDyeColor.values();
    private static final EnumFacing[] FACINGS = EnumFacing.values();
    private static final EnumHand[] HANDS = EnumHand.values();
    private static final EnumPushReaction[] PISTON_BEHAVIORS = EnumPushReaction.values();

    public static EnumDyeColor dyeColor(DyeColor dyeColor) {
        return DYES[dyeColor.ordinal()];
    }

    public static EnumFacing facing(Facing facing) {
        return FACINGS[facing.ordinal()];
    }

    public static EnumHand hand(Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static EnumPushReaction pistonReaction(PistonPushReaction pistonPushReaction) {
        return PISTON_BEHAVIORS[pistonPushReaction.ordinal()];
    }
}
