package net.meshmc.mesh.api.network.server;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.Packet;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - BlockUpdateS2CPacket
 * 1.12.2 - SPacketBlockChange
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketBlockUpdate extends Packet.Server {
    BlockPos getBlockPos();
    void setBlockPos(BlockPos blockPos);

    BlockState<?> getBlockState();
    void setBlockState(BlockState<?> blockState);
}
