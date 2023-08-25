package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketTileEntityUpdate;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;

public class SPacketTileEntityUpdateMesh extends PacketMesh.Server<BlockEntityUpdateS2CPacket> implements SPacketTileEntityUpdate {
    public SPacketTileEntityUpdateMesh(BlockEntityUpdateS2CPacket value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.BlockUpdate;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getPos();
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        ((BlockPos) getMeshValue()).set(blockPos);
    }
}
