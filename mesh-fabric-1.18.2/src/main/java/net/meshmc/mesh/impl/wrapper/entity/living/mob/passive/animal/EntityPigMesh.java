package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityPig;
import net.minecraft.entity.passive.PigEntity;

public class EntityPigMesh<T extends PigEntity> extends EntityAnimalMesh<T> implements EntityPig {
    public EntityPigMesh(T value) {
        super(value);
    }
}
