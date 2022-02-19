package net.meshmc.mesh.impl.conversion;

import net.meshmc.mesh.util.math.Facing;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;

public class MeshEnum {
    public static net.meshmc.mesh.util.math.Hand hand(Hand hand) {
        return net.meshmc.mesh.util.math.Hand.VALUES[hand.ordinal()];
    }

    public static Facing facing(Direction facing) {
        return Facing.VALUES[facing.ordinal()];
    }
}
