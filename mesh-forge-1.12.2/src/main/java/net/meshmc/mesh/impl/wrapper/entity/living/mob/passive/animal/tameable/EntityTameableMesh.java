package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.EntityTameable;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.EntityAnimalMesh;

public class EntityTameableMesh<T extends net.minecraft.entity.passive.EntityTameable> extends EntityAnimalMesh<T> implements EntityTameable {
    public EntityTameableMesh(T value) {
        super(value);
    }
}
