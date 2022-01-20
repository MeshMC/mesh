package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityCreeper;

public class EntityCreeperMesh<T extends net.minecraft.entity.monster.EntityCreeper> extends EntityHostileMesh<T> implements EntityCreeper<T> {
    public EntityCreeperMesh(T value) {
        super(value);
    }
}
