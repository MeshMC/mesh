package dev.tigr.mesh.impl.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.api.entity.living.mob.hostile.zombie.EntityHusk;

public class EntityHuskMesh<T extends net.minecraft.entity.mob.HuskEntity> extends EntityZombieMesh<T> implements EntityHusk<T> {
    public EntityHuskMesh(T value) {
        super(value);
    }
}
