package net.meshmc.mesh.impl.mixin.world;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(World.class)
public abstract class MixinWorld implements net.meshmc.mesh.api.world.World {
    @Shadow @Final public List<Entity> loadedEntityList;

    @Shadow public abstract IBlockState getBlockState(net.minecraft.util.math.BlockPos pos);

    @Override
    public BlockState<?> getBlockState(BlockPos blockPos) {
        return new BlockStateMesh(getBlockState((net.minecraft.util.math.BlockPos) blockPos));
    }
}
