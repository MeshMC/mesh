package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityBlaze;
import net.minecraft.entity.mob.BlazeEntity;

public class EntityBlazeMesh<T extends BlazeEntity> extends EntityHostileMesh<T> implements EntityBlaze {
    public EntityBlazeMesh(T value) {
        super(value);
    }
}
