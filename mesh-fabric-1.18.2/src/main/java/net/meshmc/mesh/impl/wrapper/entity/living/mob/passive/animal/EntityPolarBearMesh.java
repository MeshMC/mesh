package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityPolarBear;
import net.minecraft.entity.passive.PolarBearEntity;

public class EntityPolarBearMesh<T extends PolarBearEntity> extends EntityAnimalMesh<T> implements EntityPolarBear {
    public EntityPolarBearMesh(T value) {
        super(value);
    }
}
