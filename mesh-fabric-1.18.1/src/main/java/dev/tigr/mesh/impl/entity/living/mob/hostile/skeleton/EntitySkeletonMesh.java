package dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeleton;
import net.minecraft.entity.mob.SkeletonEntity;

public class EntitySkeletonMesh<T extends SkeletonEntity> extends EntitySkeletonAbstractMesh<T> implements EntitySkeleton<T> {
    public EntitySkeletonMesh(T value) {
        super(value);
    }
}
