package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable.shoulder;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.shoulder.EntityParrot;
import net.minecraft.entity.passive.ParrotEntity;

public class EntityParrotMesh<T extends ParrotEntity> extends EntityShoulderTameableMesh<T> implements EntityParrot {
    public EntityParrotMesh(T value) {
        super(value);
    }
}
