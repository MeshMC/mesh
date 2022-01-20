package dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeleton;

public class EntitySkeletonMesh<T extends net.minecraft.entity.monster.EntitySkeleton> extends EntitySkeletonAbstractMesh<T> implements EntitySkeleton<T> {
    public EntitySkeletonMesh(T value) {
        super(value);
    }
}
