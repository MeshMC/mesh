package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntityWitherSkeleton;

public class EntityWitherSkeletonMesh<T extends net.minecraft.entity.monster.EntityWitherSkeleton> extends EntitySkeletonAbstractMesh<T> implements EntityWitherSkeleton {
    public EntityWitherSkeletonMesh(T value) {
        super(value);
    }
}
