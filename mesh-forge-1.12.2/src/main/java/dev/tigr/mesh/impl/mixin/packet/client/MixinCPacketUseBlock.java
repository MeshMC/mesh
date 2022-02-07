package dev.tigr.mesh.impl.mixin.packet.client;

import dev.tigr.mesh.impl.conversion.MCEnum;
import dev.tigr.mesh.impl.conversion.MeshEnum;
import dev.tigr.mesh.impl.mixininterface.math.BlockPos;
import dev.tigr.mesh.impl.mixininterface.math.Vec3d;
import dev.tigr.mesh.impl.mixininterface.packet.Packet;
import dev.tigr.mesh.impl.mixininterface.packet.client.CPacketUseBlock;
import dev.tigr.mesh.util.math.Facing;
import dev.tigr.mesh.util.math.Hand;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CPacketPlayerTryUseItemOnBlock.class)
public class MixinCPacketUseBlock implements Packet, CPacketUseBlock {
    @Shadow private net.minecraft.util.math.BlockPos position;

    @Shadow private EnumFacing placedBlockDirection;

    @Shadow private EnumHand hand;

    @Shadow private float facingX;

    @Shadow private float facingZ;

    @Shadow private float facingY;

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) position;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
    }

    @Override
    public Facing getInteractedSide() {
        return MeshEnum.facing(placedBlockDirection);
    }

    @Override
    public void setInteractedSide(Facing facing) {
        placedBlockDirection = MCEnum.facing(facing);
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
        return Vec3d.create(facingX, facingY, facingZ);
    }

    @Override
    public void setInteractionVector(Vec3d vec) {
        facingX = (float) vec.getX();
        facingY = (float) vec.getY();
        facingZ = (float) vec.getZ();
    }

    @Override
    public boolean isInsideBlock() {
        // Not in 1.12.2
        return false;
    }

    @Override
    public void setInsideBlock(boolean value) {
        // Not in 1.12.2
    }
}
