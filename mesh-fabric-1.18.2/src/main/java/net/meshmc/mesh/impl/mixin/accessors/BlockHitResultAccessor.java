package net.meshmc.mesh.impl.mixin.accessors;

import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockHitResult.class)
public interface BlockHitResultAccessor {
    @Accessor("side")
    void setSide(Direction direction);

    @Accessor("insideBlock")
    void setInsideBlock(boolean value);

    @Accessor("blockPos")
    void setBlockPos(BlockPos blockPos);
}
