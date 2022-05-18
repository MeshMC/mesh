package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.util.block.PistonPushReaction;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.item.DyeColor;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.entity.MoverType;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;

public class MCEnum {
    private static final EnumDyeColor[] DYES = EnumDyeColor.values();
    private static final EnumFacing[] FACINGS = EnumFacing.values();
    private static final EnumHand[] HANDS = EnumHand.values();
    private static final MoverType[] MOVEMENT_TYPES = MoverType.values();
    private static final EnumPushReaction[] PISTON_BEHAVIORS = EnumPushReaction.values();
    private static final EnumHandSide[] ARMS = EnumHandSide.values();

    public static EnumDyeColor dyeColor(DyeColor dyeColor) {
        return DYES[dyeColor.ordinal()];
    }

    public static EnumFacing facing(Facing facing) {
        return FACINGS[facing.ordinal()];
    }

    public static EnumHand hand(Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static MoverType moverType(net.meshmc.mesh.api.entity.MoverType moverType) {
        return MOVEMENT_TYPES[moverType.ordinal()];
    }

    public static EnumPushReaction pistonReaction(PistonPushReaction pistonPushReaction) {
        return PISTON_BEHAVIORS[pistonPushReaction.ordinal()];
    }

    public static EnumHandSide arm(Arm arm) {
        return ARMS[arm.ordinal()];
    }
}
