package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityGoat;
import net.minecraft.entity.passive.GoatEntity;

public class EntityGoatMesh<T extends GoatEntity> extends EntityAnimalMesh<T> implements EntityGoat {
    public EntityGoatMesh(T value) {
        super(value);
    }
}
