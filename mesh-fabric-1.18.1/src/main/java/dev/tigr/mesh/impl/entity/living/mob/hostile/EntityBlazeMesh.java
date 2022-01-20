package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityBlaze;
import net.minecraft.entity.mob.BlazeEntity;

public class EntityBlazeMesh<T extends BlazeEntity> extends EntityHostileMesh<T> implements EntityBlaze<T> {
    public EntityBlazeMesh(T value) {
        super(value);
    }
}
