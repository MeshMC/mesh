package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntitySilverfish;
import net.minecraft.entity.mob.SilverfishEntity;

public class EntitySilverfishMesh<T extends SilverfishEntity> extends EntityHostileMesh<T> implements EntitySilverfish {
    public EntitySilverfishMesh(T value) {
        super(value);
    }
}
