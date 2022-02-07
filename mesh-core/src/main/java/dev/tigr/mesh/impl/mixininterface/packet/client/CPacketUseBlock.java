package dev.tigr.mesh.impl.mixininterface.packet.client;

import dev.tigr.mesh.impl.mixininterface.math.BlockPos;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.util.math.Facing;
import dev.tigr.mesh.util.math.Hand;

public interface CPacketUseBlock {
    BlockPos getBlockPos();
    void setBlockPos(BlockPos blockPos);

    Facing getInteractedSide();
    void setInteractedSide(Facing facing);

    Hand getHand();
    void setHand(Hand hand);

    Vec3d getInteractionVector();
    void setInteractionVector(Vec3d vec);

    // Later versions only
    boolean isInsideBlock();
    void setInsideBlock(boolean value);
}
