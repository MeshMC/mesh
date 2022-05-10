package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeleton;
import net.minecraft.entity.mob.SkeletonEntity;

public class EntitySkeletonMesh<T extends SkeletonEntity> extends EntitySkeletonAbstractMesh<T> implements EntitySkeleton {
    public EntitySkeletonMesh(T value) {
        super(value);
    }
}
