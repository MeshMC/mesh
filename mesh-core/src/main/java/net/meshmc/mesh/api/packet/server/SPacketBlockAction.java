package net.meshmc.mesh.api.packet.server;

import net.meshmc.mesh.api.math.BlockPos;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - BlockEventS2CPacket
 * 1.12.2 - SPacketBlockAction
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketBlockAction {
    BlockPos getBlockPos();

    int getInstrument();

    int getPitch();

    //TODO: Block
}
