package dev.tigr.mesh.impl.conversion;

import dev.tigr.mesh.util.math.Facing;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;

public class MeshEnum {
    public static dev.tigr.mesh.util.math.Hand hand(Hand hand) {
        return dev.tigr.mesh.util.math.Hand.VALUES[hand.ordinal()];
    }

    public static Facing facing(Direction facing) {
        return Facing.VALUES[facing.ordinal()];
    }
}
