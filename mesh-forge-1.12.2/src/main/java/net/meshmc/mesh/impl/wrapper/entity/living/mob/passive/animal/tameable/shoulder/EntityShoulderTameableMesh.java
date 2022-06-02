package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable.shoulder;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.shoulder.EntityShoulderTameable;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable.EntityTameableMesh;
import net.minecraft.entity.passive.EntityShoulderRiding;

public class EntityShoulderTameableMesh<T extends EntityShoulderRiding> extends EntityTameableMesh<T> implements EntityShoulderTameable {
    public EntityShoulderTameableMesh(T value) {
        super(value);
    }
}
