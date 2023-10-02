package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketBlockUpdate;
import net.meshmc.mesh.impl.mixin.accessors.packet.BlockUpdateS2CPacketAccessor;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;

public class SPacketBlockUpdateMesh extends PacketMesh.Server<BlockUpdateS2CPacket> implements SPacketBlockUpdate {
    public SPacketBlockUpdateMesh(BlockUpdateS2CPacket value) {
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
        ((BlockPos) getMeshValue().getPos()).set(blockPos);
    }

    @Override
    public BlockState<?> getBlockState() {
        return new BlockStateMesh(getMeshValue().getState());
    }

    @Override
    public void setBlockState(BlockState<?> blockState) {
        ((BlockUpdateS2CPacketAccessor) getMeshValue()).setState((net.minecraft.block.BlockState) blockState.getMeshValue());
    }
}
