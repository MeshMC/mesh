package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.skeleton;

import net.meshmc.mesh.api.entity.living.mob.hostile.skeleton.EntityStray;
import net.minecraft.entity.mob.StrayEntity;

public class EntityStrayMesh<T extends StrayEntity> extends EntitySkeletonAbstractMesh<T> implements EntityStray {
    public EntityStrayMesh(T value) {
        super(value);
    }
}
