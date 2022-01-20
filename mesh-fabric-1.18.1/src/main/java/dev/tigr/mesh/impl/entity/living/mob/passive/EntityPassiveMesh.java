package dev.tigr.mesh.impl.entity.living.mob.passive;

import dev.tigr.mesh.api.entity.living.mob.passive.EntityPassive;
import dev.tigr.mesh.impl.entity.living.mob.EntityMobMesh;

public class EntityPassiveMesh<T extends net.minecraft.entity.passive.PassiveEntity> extends EntityMobMesh<T> implements EntityPassive<T> {
    public EntityPassiveMesh(T value) {
        super(value);
    }
}
