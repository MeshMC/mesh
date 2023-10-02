package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityPolarBear;

public class EntityPolarBearMesh<T extends net.minecraft.entity.monster.EntityPolarBear> extends EntityAnimalMesh<T> implements EntityPolarBear {
    public EntityPolarBearMesh(T value) {
        super(value);
    }
}
