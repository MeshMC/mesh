package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityEndermite;
import net.minecraft.entity.mob.EndermiteEntity;

public class EntityEndermiteMesh<T extends EndermiteEntity> extends EntityHostileMesh<T> implements EntityEndermite<T> {
    public EntityEndermiteMesh(T value) {
        super(value);
    }
}
