package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityVex;
import net.minecraft.entity.mob.VexEntity;

public class EntityVexMesh<T extends VexEntity> extends EntityHostileMesh<T> implements EntityVex<T> {
    public EntityVexMesh(T value) {
        super(value);
    }
}
