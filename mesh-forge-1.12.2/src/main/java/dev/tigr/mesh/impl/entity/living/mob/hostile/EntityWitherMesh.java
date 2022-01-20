package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityWither;

public class EntityWitherMesh<T extends net.minecraft.entity.boss.EntityWither> extends EntityHostileMesh<T> implements EntityWither<T> {
    public EntityWitherMesh(T value) {
        super(value);
    }
}
