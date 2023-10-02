package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityStrider;
import net.minecraft.entity.passive.StriderEntity;

public class EntityStriderMesh<T extends StriderEntity> extends EntityAnimalMesh<T> implements EntityStrider {
    public EntityStriderMesh(T value) {
        super(value);
    }
}
