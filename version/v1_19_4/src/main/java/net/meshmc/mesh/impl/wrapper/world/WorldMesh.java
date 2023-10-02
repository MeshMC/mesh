package net.meshmc.mesh.impl.wrapper.world;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.block.BlockState;
import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.block.BlockStateMesh;
import net.minecraft.world.World;

public class WorldMesh<T extends World> extends AbstractMesh<T> implements net.meshmc.mesh.api.world.World {
    public WorldMesh(T value) {
        super(value);
    }

    @Override
    public BlockState<?> getBlockState(BlockPos blockPos) {
        return new BlockStateMesh(getMeshValue().getBlockState((net.minecraft.util.math.BlockPos) blockPos));
    }

    @Override
    public Entity getEntityByID(int id) {
        return Mappings.entity(getMeshValue().getEntityById(id));
    }
}
