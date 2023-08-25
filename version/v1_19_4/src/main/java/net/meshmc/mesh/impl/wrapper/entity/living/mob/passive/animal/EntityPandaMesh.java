package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityPanda;
import net.minecraft.entity.passive.PandaEntity;

public class EntityPandaMesh<T extends PandaEntity> extends EntityAnimalMesh<T> implements EntityPanda {
    public EntityPandaMesh(T value) {
        super(value);
    }
}
