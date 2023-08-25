package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityWither;
import net.minecraft.entity.boss.WitherEntity;

public class EntityWitherMesh<T extends WitherEntity> extends EntityHostileMesh<T> implements EntityWither {
    public EntityWitherMesh(T value) {
        super(value);
    }
}
