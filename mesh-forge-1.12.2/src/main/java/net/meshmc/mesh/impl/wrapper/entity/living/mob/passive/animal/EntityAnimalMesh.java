package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityAnimal;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.EntityPassiveMesh;

public class EntityAnimalMesh<T extends net.minecraft.entity.passive.EntityAnimal> extends EntityPassiveMesh<T> implements EntityAnimal {
    public EntityAnimalMesh(T value) {
        super(value);
    }
}
