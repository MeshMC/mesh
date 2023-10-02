package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityChicken;
import net.minecraft.entity.passive.ChickenEntity;

public class EntityChickenMesh<T extends ChickenEntity> extends EntityAnimalMesh<T> implements EntityChicken {
    public EntityChickenMesh(T value) {
        super(value);
    }
}
