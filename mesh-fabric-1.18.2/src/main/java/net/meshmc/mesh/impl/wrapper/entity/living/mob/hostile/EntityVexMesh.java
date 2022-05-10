package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityVex;
import net.minecraft.entity.mob.VexEntity;

public class EntityVexMesh<T extends VexEntity> extends EntityHostileMesh<T> implements EntityVex {
    public EntityVexMesh(T value) {
        super(value);
    }
}
