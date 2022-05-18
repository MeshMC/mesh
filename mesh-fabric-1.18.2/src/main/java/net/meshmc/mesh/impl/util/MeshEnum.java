package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.api.entity.MoverType;
import net.meshmc.mesh.util.block.PistonPushReaction;
import net.meshmc.mesh.util.entity.ActionResult;
import net.meshmc.mesh.util.entity.Arm;
import net.meshmc.mesh.util.entity.Stance;
import net.meshmc.mesh.util.item.DyeColor;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.MovementType;
import net.minecraft.util.math.Direction;

public class MeshEnum {
    private static final DyeColor[] DYES = DyeColor.values();
    private static final Facing[] FACINGS = Facing.values();
    private static final Hand[] HANDS = Hand.values();
    private static final MoverType[] MOVER_TYPES = MoverType.values();
    private static final PistonPushReaction[] PISTON_BEHAVIORS = PistonPushReaction.values();
    private static final Stance[] STANCES = Stance.values();
    private static final ActionResult[] ACTION_RESULTS = ActionResult.values();
    private static final Arm[] ARMS = Arm.values();

    public static DyeColor dyeColor(net.minecraft.util.DyeColor dyeColor) {
        return DYES[dyeColor.ordinal()];
    }

    public static Facing facing(Direction facing) {
        return FACINGS[facing.ordinal()];
    }

    public static Hand hand(net.minecraft.util.Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static MoverType moverType(MovementType movementType) {
        return MOVER_TYPES[movementType.ordinal()];
    }

    public static PistonPushReaction pistonReaction(PistonBehavior pistonBehavior) {
        return PISTON_BEHAVIORS[pistonBehavior.ordinal()];
    }

    public static Stance stance(net.minecraft.entity.EntityPose entityPose) {
        return STANCES[entityPose.ordinal()];
    }

    public static ActionResult actionResult(net.minecraft.util.ActionResult actionResult) {
        int ordinal = actionResult.ordinal();
        if(ordinal >= 3) return ACTION_RESULTS[ordinal - 2];
        else return ActionResult.SUCCESS;
    }

    public static Arm arm(net.minecraft.util.Arm arm) {
        return ARMS[arm.ordinal()];
    }
}
