package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.client.CPacketUseBlock;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketPlayerTryUseItemOnBlockAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;

import javax.annotation.Nullable;

public class CPacketUseBlockMesh extends PacketMesh.Client<CPacketPlayerTryUseItemOnBlock> implements CPacketUseBlock {
    public CPacketUseBlockMesh(CPacketPlayerTryUseItemOnBlock value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.UseBlock;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getPos();
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        ((CPacketPlayerTryUseItemOnBlockAccessor) getMeshValue()).setBlockPos((net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public Facing getInteractedSide() {
        return MeshEnum.facing(getMeshValue().getDirection());
    }

    @Override
    public void setInteractedSide(Facing facing) {
        ((CPacketPlayerTryUseItemOnBlockAccessor) getMeshValue()).setSide(MCEnum.facing(facing));
    }

    @Override
    public Hand getHand() {
        return MeshEnum.hand(getMeshValue().getHand());
    }

    @Override
    public void setHand(Hand hand) {
        ((CPacketPlayerTryUseItemOnBlockAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
    }

    @Override
    public Vec3d getInteractionVector() {
        return Vec3d.create(getMeshValue().getFacingX(), getMeshValue().getFacingY(), getMeshValue().getFacingZ());
    }

    @Override
    public void setInteractionVector(Vec3d vec) {
        ((CPacketPlayerTryUseItemOnBlockAccessor) getMeshValue()).setX((float) vec.getX());
        ((CPacketPlayerTryUseItemOnBlockAccessor) getMeshValue()).setY((float) vec.getY());
        ((CPacketPlayerTryUseItemOnBlockAccessor) getMeshValue()).setZ((float) vec.getZ());
    }

    @Nullable
    @Override
    public Boolean isInsideBlock() {
        return null;
    }

    @Override
    public void setInsideBlock(boolean value) {}
}
