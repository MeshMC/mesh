package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityEndermite;

public class EntityEndermiteMesh<T extends net.minecraft.entity.monster.EntityEndermite> extends EntityHostileMesh<T> implements EntityEndermite<T> {
    public EntityEndermiteMesh(T value) {
        super(value);
    }
}
