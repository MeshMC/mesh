package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityVex;

public class EntityVexMesh<T extends net.minecraft.entity.monster.EntityVex> extends EntityHostileMesh<T> implements EntityVex {
    public EntityVexMesh(T value) {
        super(value);
    }
}
