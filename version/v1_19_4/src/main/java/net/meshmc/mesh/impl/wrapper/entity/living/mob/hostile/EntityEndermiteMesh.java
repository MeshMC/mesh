package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityEndermite;
import net.minecraft.entity.mob.EndermiteEntity;

public class EntityEndermiteMesh<T extends EndermiteEntity> extends EntityHostileMesh<T> implements EntityEndermite {
    public EntityEndermiteMesh(T value) {
        super(value);
    }
}
