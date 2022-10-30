package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketBreakProgress;
import net.meshmc.mesh.impl.mixin.accessors.packet.SPacketBlockBreakAnimAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;

public class SPacketBreakProgressMesh extends PacketMesh.Server<SPacketBlockBreakAnim> implements SPacketBreakProgress {
    public SPacketBreakProgressMesh(SPacketBlockBreakAnim value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.BreakProgress;
    }

    @Override
    public int getEntityId() {
        return getMeshValue().getBreakerId();
    }

    @Override
    public void setEntityId(int value) {
        ((SPacketBlockBreakAnimAccessor) getMeshValue()).setEntityId(value);
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getPosition();
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        ((BlockPos) getMeshValue().getPosition()).set(blockPos);
    }

    @Override
    public int getProgress() {
        return getMeshValue().getProgress();
    }

    @Override
    public void setProgress(int value) {
        ((SPacketBlockBreakAnimAccessor) getMeshValue()).setProgress(value);
    }
}
