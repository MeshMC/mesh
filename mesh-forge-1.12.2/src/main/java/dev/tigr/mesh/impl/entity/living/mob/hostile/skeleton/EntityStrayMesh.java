package dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.api.entity.living.mob.hostile.skeleton.EntityStray;

public class EntityStrayMesh<T extends net.minecraft.entity.monster.EntityStray> extends EntitySkeletonAbstractMesh<T> implements EntityStray<T> {
    public EntityStrayMesh(T value) {
        super(value);
    }
}
