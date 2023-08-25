package net.meshmc.mesh.api.network.server;

import net.meshmc.mesh.api.block.Block;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.Packet;
import org.jetbrains.annotations.Nullable;

/**
 * Provides a mesh implementation for:
 * 1.18.2 - BlockEventS2CPacket
 * 1.12.2 - SPacketBlockAction
 *
 * @author Makrennel 03/15/22
 */
public interface SPacketBlockAction extends Packet.Server {
    BlockPos getBlockPos();

    int getInstrument();

    int getPitch();

    Block getBlock();
    @Nullable
    Enum<?> getBlockVariant();

    void setBlock(Block block, @Nullable Enum<?> blockVariant);
}
