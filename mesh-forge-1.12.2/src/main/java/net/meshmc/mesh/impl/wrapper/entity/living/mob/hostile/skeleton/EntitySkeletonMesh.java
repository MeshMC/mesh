package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeleton;

public class EntitySkeletonMesh<T extends net.minecraft.entity.monster.EntitySkeleton> extends EntitySkeletonAbstractMesh<T> implements EntitySkeleton {
    public EntitySkeletonMesh(T value) {
        super(value);
    }
}
