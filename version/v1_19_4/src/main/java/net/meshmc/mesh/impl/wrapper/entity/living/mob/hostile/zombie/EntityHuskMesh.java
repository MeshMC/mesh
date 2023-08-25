package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityHusk;
import net.minecraft.entity.mob.HuskEntity;

public class EntityHuskMesh<T extends HuskEntity> extends EntityZombieMesh<T> implements EntityHusk {
    public EntityHuskMesh(T value) {
        super(value);
    }
}
