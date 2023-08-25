package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityBlaze;

public class EntityBlazeMesh<T extends net.minecraft.entity.monster.EntityBlaze> extends EntityHostileMesh<T> implements EntityBlaze {
    public EntityBlazeMesh(T value) {
        super(value);
    }
}
