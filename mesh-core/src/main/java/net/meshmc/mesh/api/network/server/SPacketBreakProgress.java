package net.meshmc.mesh.api.network.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.Packet;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - BlockBreakingProgressS2CPacket
 * 1.12.2 - SPacketBlockBreakAnim
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketBreakProgress extends Packet.Server {
    int getEntityId();
    void setEntityId(int value);

    BlockPos getBlockPos();
    void setBlockPos(BlockPos blockPos);

    int getProgress();
    void setProgress(int value);
}
