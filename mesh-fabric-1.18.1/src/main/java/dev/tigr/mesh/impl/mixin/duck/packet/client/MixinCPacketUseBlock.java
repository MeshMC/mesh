package dev.tigr.mesh.impl.mixin.duck.packet.client;

import dev.tigr.mesh.impl.conversion.MCEnum;
import dev.tigr.mesh.impl.conversion.MeshEnum;
import dev.tigr.mesh.impl.mixin.accessors.BlockHitResultAccessor;
import dev.tigr.mesh.impl.mixininterface.math.BlockPos;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketUseBlock;
import dev.tigr.mesh.util.math.Facing;
import dev.tigr.mesh.util.math.Hand;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.hit.BlockHitResult;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerInteractBlockC2SPacket.class)
public class MixinCPacketUseBlock implements CPacketUseBlock {
    @Shadow @Final private BlockHitResult blockHitResult;
    @Mutable @Shadow @Final private net.minecraft.util.Hand hand;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) blockHitResult.getBlockPos();
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        ((BlockPos) blockHitResult.getBlockPos()).set(blockPos);
    }

    @Override
    public Facing getInteractedSide() {
        return MeshEnum.facing(blockHitResult.getSide());
    }

    @Override
    public void setInteractedSide(Facing facing) {
        ((BlockHitResultAccessor) blockHitResult).setSide(MCEnum.facing(facing));
    }

    @Override
    public Hand getHand() {
        return MeshEnum.hand(hand);
    }

    @Override
    public void setHand(Hand hand) {
        this.hand = MCEnum.hand(hand);
    }

    @Override
    public Vec3d getInteractionVector() {
        return ((Vec3d) blockHitResult.getPos()).subtract((BlockPos) blockHitResult.getBlockPos());
    }

    @Override
    public void setInteractionVector(Vec3d vec) {
        ((Vec3d) blockHitResult.getPos()).set(vec.add((BlockPos) blockHitResult.getBlockPos()));
    }

    @Override
    public boolean isInsideBlock() {
        return blockHitResult.isInsideBlock();
    }

    @Override
    public void setInsideBlock(boolean value) {
        ((BlockHitResultAccessor) blockHitResult).setInsideBlock(value);
    }
}
