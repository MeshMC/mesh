package net.meshmc.mesh.api.world;

import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.BlockPos;

public interface World {
    BlockState<?> getBlockState(BlockPos blockPos);

    Entity getEntityByID(int id);
}
