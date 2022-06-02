package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable.shoulder;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.shoulder.EntityParrot;

public class EntityParrotMesh<T extends net.minecraft.entity.passive.EntityParrot> extends EntityShoulderTameableMesh<T> implements EntityParrot {
    public EntityParrotMesh(T value) {
        super(value);
    }
}
