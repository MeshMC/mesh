package dev.tigr.mesh.impl.conversion;

import dev.tigr.mesh.util.math.Facing;
import dev.tigr.mesh.util.math.Hand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;

public class MCEnum {
    public static EnumHand[] HANDS = EnumHand.values();
    public static EnumFacing[] FACINGS = EnumFacing.values();

    public static EnumHand hand(Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static EnumFacing facing(Facing facing) {
        return FACINGS[facing.ordinal()];
    }
}
