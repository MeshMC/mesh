package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntitySkeletonAbstract;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.AbstractSkeletonEntity;

public class EntitySkeletonAbstractMesh<T extends AbstractSkeletonEntity> extends EntityHostileMesh<T> implements EntitySkeletonAbstract {
    public EntitySkeletonAbstractMesh(T value) {
        super(value);
    }
}
