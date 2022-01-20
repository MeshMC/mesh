package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityVex;

public class EntityVexMesh<T extends net.minecraft.entity.monster.EntityVex> extends EntityHostileMesh<T> implements EntityVex<T> {
    public EntityVexMesh(T value) {
        super(value);
    }
}
