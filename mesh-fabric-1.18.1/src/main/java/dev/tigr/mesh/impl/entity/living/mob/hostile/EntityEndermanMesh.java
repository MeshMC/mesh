package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityEnderman;
import net.minecraft.entity.mob.EndermanEntity;

public class EntityEndermanMesh<T extends EndermanEntity> extends EntityHostileMesh<T> implements EntityEnderman<T> {
    public EntityEndermanMesh(T value) {
        super(value);
    }
}
