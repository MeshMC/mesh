package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityWither;
import net.minecraft.entity.boss.WitherEntity;

public class EntityWitherMesh<T extends WitherEntity> extends EntityHostileMesh<T> implements EntityWither<T> {
    public EntityWitherMesh(T value) {
        super(value);
    }
}
