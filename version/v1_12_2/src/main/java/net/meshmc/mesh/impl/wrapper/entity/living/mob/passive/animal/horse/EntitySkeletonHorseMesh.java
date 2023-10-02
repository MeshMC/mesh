package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.EntitySkeletonHorse;

public class EntitySkeletonHorseMesh<T extends net.minecraft.entity.passive.EntitySkeletonHorse> extends EntityHorseBaseMesh<T> implements EntitySkeletonHorse {
    public EntitySkeletonHorseMesh(T value) {
        super(value);
    }
}
