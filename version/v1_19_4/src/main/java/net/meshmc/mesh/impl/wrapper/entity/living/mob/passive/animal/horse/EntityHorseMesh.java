package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.EntityHorse;
import net.minecraft.entity.passive.HorseEntity;

public class EntityHorseMesh<T extends HorseEntity> extends EntityHorseBaseMesh<T> implements EntityHorse {
    public EntityHorseMesh(T value) {
        super(value);
    }
}
