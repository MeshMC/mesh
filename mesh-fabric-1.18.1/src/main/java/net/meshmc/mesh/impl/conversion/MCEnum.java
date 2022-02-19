package net.meshmc.mesh.impl.conversion;

import net.meshmc.mesh.util.math.Facing;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;

public class MCEnum {
    public static Hand[] HANDS = Hand.values();
    public static Direction[] FACINGS = Direction.values();

    public static Hand hand(net.meshmc.mesh.util.math.Hand hand) {
        return HANDS[hand.ordinal()];
    }

    public static Direction facing(Facing facing) {
        return FACINGS[facing.ordinal()];
    }
}
