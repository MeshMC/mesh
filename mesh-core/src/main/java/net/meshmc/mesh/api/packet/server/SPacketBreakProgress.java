package net.meshmc.mesh.api.packet.server;

import net.meshmc.mesh.api.math.BlockPos;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - BlockBreakingProgressS2CPacket
 * 1.12.2 - SPacketBlockBreakAnim
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketBreakProgress {
    int getEntityId();

    BlockPos getBlockPos();

    int getProgress();
}
