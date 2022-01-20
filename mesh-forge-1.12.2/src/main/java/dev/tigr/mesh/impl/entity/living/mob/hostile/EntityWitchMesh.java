package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityWitch;

public class EntityWitchMesh<T extends net.minecraft.entity.monster.EntityWitch> extends EntityHostileMesh<T> implements EntityWitch<T> {
    public EntityWitchMesh(T value) {
        super(value);
    }
}
