package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityWither;

public class EntityWitherMesh<T extends net.minecraft.entity.boss.EntityWither> extends EntityHostileMesh<T> implements EntityWither {
    public EntityWitherMesh(T value) {
        super(value);
    }
}
