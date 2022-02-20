package net.meshmc.mesh.api.packet.client;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;

/**
 * Provides an interface for block interaction packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketUseBlock {
    static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock) {
        return MeshStatics.createCPacketUseBlock(hand, blockPos, facing, vector, insideBlock);
    }

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
