package dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeletonAbstract;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.AbstractSkeletonEntity;

public class EntitySkeletonAbstractMesh<T extends AbstractSkeletonEntity> extends EntityHostileMesh<T> implements EntitySkeletonAbstract<T> {
    public EntitySkeletonAbstractMesh(T value) {
        super(value);
    }
}
