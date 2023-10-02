package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntityStray;

public class EntityStrayMesh<T extends net.minecraft.entity.monster.EntityStray> extends EntitySkeletonAbstractMesh<T> implements EntityStray {
    public EntityStrayMesh(T value) {
        super(value);
    }
}
