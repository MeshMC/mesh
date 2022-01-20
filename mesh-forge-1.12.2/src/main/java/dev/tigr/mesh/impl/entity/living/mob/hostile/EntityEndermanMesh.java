package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityEnderman;

public class EntityEndermanMesh<T extends net.minecraft.entity.monster.EntityEnderman> extends EntityHostileMesh<T> implements EntityEnderman<T> {
    public EntityEndermanMesh(T value) {
        super(value);
    }
}
