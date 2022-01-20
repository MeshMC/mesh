package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntitySilverfish;

public class EntitySilverfishMesh<T extends net.minecraft.entity.monster.EntitySilverfish> extends EntityHostileMesh<T> implements EntitySilverfish<T> {
    public EntitySilverfishMesh(T value) {
        super(value);
    }
}
