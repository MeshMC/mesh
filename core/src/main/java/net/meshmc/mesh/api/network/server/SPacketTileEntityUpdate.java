package net.meshmc.mesh.api.network.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.Packet;

/**
 * Provides a mesh implementation for:
 * 1.18.1 - BlockEntityUpdateS2CPacket
 * 1.12.2 - SPacketUpdateTileEntity
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketTileEntityUpdate extends Packet.Server {
    BlockPos getBlockPos();
    void setBlockPos(BlockPos blockPos);

    // TODO: BlockEntityType & NBT
}
