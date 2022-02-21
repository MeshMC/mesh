package net.meshmc.mesh.impl.util;

import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;

public class MeshEnum {
    public static Hand hand(EnumHand hand) {
        return Hand.VALUES[hand.ordinal()];
    }

    public static Facing facing(EnumFacing facing) {
        return Facing.VALUES[facing.ordinal()];
    }
}
