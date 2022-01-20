package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityBlaze;

public class EntityBlazeMesh<T extends net.minecraft.entity.monster.EntityBlaze> extends EntityHostileMesh<T> implements EntityBlaze<T> {
    public EntityBlazeMesh(T value) {
        super(value);
    }
}
