package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketPlayerTryUseItemOnBlock.class)
public interface CPacketPlayerTryUseItemOnBlockAccessor {
    @Accessor("position")
    void setBlockPos(BlockPos blockPos);

    @Accessor("placedBlockDirection")
    void setSide(EnumFacing side);

    @Accessor("hand")
    void setHand(EnumHand hand);

    @Accessor("facingX")
    void setX(float value);

    @Accessor("facingY")
    void setY(float value);

    @Accessor("facingZ")
    void setZ(float value);
}
