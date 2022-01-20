package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntitySilverfish;
import net.minecraft.entity.mob.SilverfishEntity;

public class EntitySilverfishMesh<T extends SilverfishEntity> extends EntityHostileMesh<T> implements EntitySilverfish<T> {
    public EntitySilverfishMesh(T value) {
        super(value);
    }
}
