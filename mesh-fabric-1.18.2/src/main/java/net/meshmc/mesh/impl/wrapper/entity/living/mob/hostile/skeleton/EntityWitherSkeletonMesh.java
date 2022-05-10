package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntityWitherSkeleton;
import net.minecraft.entity.mob.WitherSkeletonEntity;

public class EntityWitherSkeletonMesh<T extends WitherSkeletonEntity> extends EntitySkeletonAbstractMesh<T> implements EntityWitherSkeleton {
    public EntityWitherSkeletonMesh(T value) {
        super(value);
    }
}
