package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketBreakProgress;
import net.meshmc.mesh.impl.mixin.accessors.packet.BlockBreakingProgressS2CPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.s2c.play.BlockBreakingProgressS2CPacket;

public class SPacketBreakProgressMesh extends PacketMesh.Server<BlockBreakingProgressS2CPacket> implements SPacketBreakProgress {
    public SPacketBreakProgressMesh(BlockBreakingProgressS2CPacket value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.BreakProgress;
    }

    @Override
    public int getEntityId() {
        return getMeshValue().getEntityId();
    }

    @Override
    public void setEntityId(int value) {
        ((BlockBreakingProgressS2CPacketAccessor) getMeshValue()).setEntityId(value);
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
    public int getProgress() {
        return getMeshValue().getProgress();
    }

    @Override
    public void setProgress(int value) {
        ((BlockBreakingProgressS2CPacketAccessor) getMeshValue()).setProgress(value);
    }
}
