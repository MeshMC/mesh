package net.meshmc.mesh.api.network.client;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.Packet;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.MCVersion;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;

import javax.annotation.Nullable;

/**
 * Provides an interface for block interaction packets
 * @author Makrennel 2022/02/09
 */
public interface CPacketUseBlock extends Packet.Client {
    static CPacketUseBlock createCPacketUseBlock(Hand hand, BlockPos blockPos, Facing facing, Vec3d vector, boolean insideBlock) {
        return StaticPackets.createCPacketUseBlock(hand, blockPos, facing, vector, insideBlock);
    }

    BlockPos getBlockPos();
    void setBlockPos(BlockPos blockPos);

    Facing getInteractedSide();
    void setInteractedSide(Facing facing);

    Hand getHand();
    void setHand(Hand hand);

    Vec3d getInteractionVector();
    void setInteractionVector(Vec3d vec);

    @Nullable
    @MCVersion.OnlyOn(value = MCVersion.v1_14, minimumVersion = true)
    Boolean isInsideBlock();
    @MCVersion.OnlyOn(value = MCVersion.v1_14, minimumVersion = true)
    void setInsideBlock(boolean value);
}
