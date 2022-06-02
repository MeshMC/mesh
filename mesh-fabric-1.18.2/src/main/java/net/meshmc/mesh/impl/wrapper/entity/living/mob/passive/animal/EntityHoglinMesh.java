package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityHoglin;
import net.minecraft.entity.mob.HoglinEntity;

public class EntityHoglinMesh<T extends HoglinEntity> extends EntityAnimalMesh<T> implements EntityHoglin {
    public EntityHoglinMesh(T value) {
        super(value);
    }
}
