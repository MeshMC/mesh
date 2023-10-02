package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.network.client.CPacketUseBlock;
import net.meshmc.mesh.impl.mixin.accessors.BlockHitResultAccessor;
import net.meshmc.mesh.impl.mixin.accessors.HitResultAccessor;
import net.meshmc.mesh.impl.mixin.accessors.packet.PlayerInteractBlockC2SPacketAccessor;
import net.meshmc.mesh.impl.util.MCEnum;
import net.meshmc.mesh.impl.util.MeshEnum;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.meshmc.mesh.util.math.Facing;
import net.meshmc.mesh.util.math.Hand;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;

public class CPacketUseBlockMesh extends PacketMesh.Client<PlayerInteractBlockC2SPacket> implements CPacketUseBlock {
    public CPacketUseBlockMesh(PlayerInteractBlockC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.UseBlock;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getBlockHitResult().getBlockPos();
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        ((BlockHitResultAccessor) getMeshValue().getBlockHitResult()).setBlockPos((net.minecraft.util.math.BlockPos) blockPos);
    }

    @Override
    public Facing getInteractedSide() {
        return MeshEnum.facing(getMeshValue().getBlockHitResult().getSide());
    }

    @Override
    public void setInteractedSide(Facing facing) {
        ((BlockHitResultAccessor) getMeshValue().getBlockHitResult()).setSide(MCEnum.facing(facing));
    }

    @Override
    public Hand getHand() {
        return MeshEnum.hand(getMeshValue().getHand());
    }

    @Override
    public void setHand(Hand hand) {
        ((PlayerInteractBlockC2SPacketAccessor) getMeshValue()).setHand(MCEnum.hand(hand));
    }

    @Override
    public Vec3d getInteractionVector() {
        return (Vec3d) getMeshValue().getBlockHitResult().getPos();
    }

    @Override
    public void setInteractionVector(Vec3d vec) {
        ((HitResultAccessor) getMeshValue().getBlockHitResult()).setPos((net.minecraft.util.math.Vec3d) vec);
    }

    @Override
    public Boolean isInsideBlock() {
        return getMeshValue().getBlockHitResult().isInsideBlock();
    }

    @Override
    public void setInsideBlock(boolean value) {
        ((BlockHitResultAccessor) getMeshValue().getBlockHitResult()).setInsideBlock(value);
    }
}
