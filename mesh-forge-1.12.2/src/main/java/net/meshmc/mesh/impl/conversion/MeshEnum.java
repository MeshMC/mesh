package net.meshmc.mesh.impl.conversion;

import net.meshmc.mesh.util.math.Facing;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.meshmc.mesh.util.math.Hand;

public class MeshEnum {
    public static Hand hand(EnumHand hand) {
        return Hand.VALUES[hand.ordinal()];
    }

    public static Facing facing(EnumFacing facing) {
        return Facing.VALUES[facing.ordinal()];
    }
}
