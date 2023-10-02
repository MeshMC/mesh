package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityEnderman;
import net.minecraft.entity.mob.EndermanEntity;

public class EntityEndermanMesh<T extends EndermanEntity> extends EntityHostileMesh<T> implements EntityEnderman {
    public EntityEndermanMesh(T value) {
        super(value);
    }
}
