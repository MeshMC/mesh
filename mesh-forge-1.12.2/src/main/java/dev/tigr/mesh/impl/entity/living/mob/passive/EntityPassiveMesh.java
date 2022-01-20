package dev.tigr.mesh.impl.entity.living.mob.passive;

import dev.tigr.mesh.api.entity.living.mob.passive.EntityPassive;
import dev.tigr.mesh.impl.entity.living.mob.EntityMobMesh;
import net.minecraft.entity.EntityAgeable;

public class EntityPassiveMesh<T extends EntityAgeable> extends EntityMobMesh<T> implements EntityPassive<T> {
    public EntityPassiveMesh(T value) {
        super(value);
    }
}
