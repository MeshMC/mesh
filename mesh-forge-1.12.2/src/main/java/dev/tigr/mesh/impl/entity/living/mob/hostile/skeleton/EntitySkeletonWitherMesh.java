package dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeletonWither;
import net.minecraft.entity.monster.EntityWitherSkeleton;

public class EntitySkeletonWitherMesh<T extends EntityWitherSkeleton> extends EntitySkeletonAbstractMesh<T> implements EntitySkeletonWither<T> {
    public EntitySkeletonWitherMesh(T value) {
        super(value);
    }
}
