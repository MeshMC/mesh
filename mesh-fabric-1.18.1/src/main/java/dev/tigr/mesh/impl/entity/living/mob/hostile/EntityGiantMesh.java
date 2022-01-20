package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.mob.GiantEntity;

public class EntityGiantMesh<T extends GiantEntity> extends EntityHostileMesh<T> implements EntityGiant<T> {
    public EntityGiantMesh(T value) {
        super(value);
    }
}
