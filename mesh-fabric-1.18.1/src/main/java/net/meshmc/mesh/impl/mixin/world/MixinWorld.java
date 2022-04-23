package net.meshmc.mesh.impl.mixin.world;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(World.class)
public abstract class MixinWorld implements net.meshmc.mesh.api.world.World {
    @Shadow public abstract net.minecraft.block.BlockState getBlockState(net.minecraft.util.math.BlockPos par1);

    @Override
    public BlockState<?> getBlockState(BlockPos blockPos) {
        return new BlockStateMesh(getBlockState((net.minecraft.util.math.BlockPos) blockPos));
    }
}
