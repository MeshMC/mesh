package dev.tigr.mesh.impl.entity.living.mob.hostile.skeleton;

import dev.tigr.mesh.api.entity.living.mob.hostile.skeleton.EntityStray;
import net.minecraft.entity.mob.StrayEntity;

public class EntityStrayMesh<T extends StrayEntity> extends EntitySkeletonAbstractMesh<T> implements EntityStray<T> {
    public EntityStrayMesh(T value) {
        super(value);
    }
}
