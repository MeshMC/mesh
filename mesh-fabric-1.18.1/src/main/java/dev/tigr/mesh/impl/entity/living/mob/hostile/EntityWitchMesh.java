package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityWitch;
import net.minecraft.entity.mob.WitchEntity;

public class EntityWitchMesh<T extends WitchEntity> extends EntityHostileMesh<T> implements EntityWitch<T> {
    public EntityWitchMesh(T value) {
        super(value);
    }
}
