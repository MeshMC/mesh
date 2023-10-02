package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketBlockUpdate;
import net.meshmc.mesh.impl.mixin.accessors.packet.SPacketBlockChangeAccessor;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.play.server.SPacketBlockChange;

public class SPacketBlockUpdateMesh extends PacketMesh.Server<SPacketBlockChange> implements SPacketBlockUpdate {
    public SPacketBlockUpdateMesh(SPacketBlockChange value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.BlockUpdate;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getBlockPosition();
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        ((BlockPos) getMeshValue().getBlockPosition()).set(blockPos);
    }

    @Override
    public BlockState<?> getBlockState() {
        return new BlockStateMesh(getMeshValue().getBlockState());
    }

    @Override
    public void setBlockState(BlockState<?> blockState) {
        ((SPacketBlockChangeAccessor) getMeshValue()).setState((IBlockState) blockState.getMeshValue());
    }
}
