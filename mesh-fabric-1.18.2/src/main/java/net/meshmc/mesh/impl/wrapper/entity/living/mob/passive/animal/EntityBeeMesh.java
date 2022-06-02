package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityBee;
import net.minecraft.entity.passive.BeeEntity;

public class EntityBeeMesh<T extends BeeEntity> extends EntityAnimalMesh<T> implements EntityBee {
    public EntityBeeMesh(T value) {
        super(value);
    }
}
