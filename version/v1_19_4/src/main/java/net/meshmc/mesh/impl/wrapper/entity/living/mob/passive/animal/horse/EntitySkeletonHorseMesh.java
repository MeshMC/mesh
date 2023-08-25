package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.EntitySkeletonHorse;
import net.minecraft.entity.mob.SkeletonHorseEntity;

public class EntitySkeletonHorseMesh<T extends SkeletonHorseEntity> extends EntityHorseBaseMesh<T> implements EntitySkeletonHorse {
    public EntitySkeletonHorseMesh(T value) {
        super(value);
    }
}
