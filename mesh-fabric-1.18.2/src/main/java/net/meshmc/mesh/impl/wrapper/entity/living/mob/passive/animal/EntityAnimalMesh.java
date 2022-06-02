package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityAnimal;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.EntityPassiveMesh;
import net.minecraft.entity.passive.AnimalEntity;

public class EntityAnimalMesh<T extends AnimalEntity> extends EntityPassiveMesh<T> implements EntityAnimal {
    public EntityAnimalMesh(T value) {
        super(value);
    }
}
