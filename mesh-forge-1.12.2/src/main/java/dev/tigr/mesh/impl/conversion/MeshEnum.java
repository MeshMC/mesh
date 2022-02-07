package dev.tigr.mesh.impl.conversion;

import dev.tigr.mesh.util.math.Facing;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;

public class MeshEnum {
    public static dev.tigr.mesh.util.math.Hand hand(EnumHand hand) {
        return dev.tigr.mesh.util.math.Hand.VALUES[hand.ordinal()];
    }

    public static Facing facing(EnumFacing facing) {
        return Facing.VALUES[facing.ordinal()];
    }
}
