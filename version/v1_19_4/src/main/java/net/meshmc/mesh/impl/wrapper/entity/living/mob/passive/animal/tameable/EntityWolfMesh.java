package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.EntityWolf;
import net.minecraft.entity.passive.WolfEntity;

public class EntityWolfMesh<T extends WolfEntity> extends EntityTameableMesh<T> implements EntityWolf {
    public EntityWolfMesh(T value) {
        super(value);
    }
}
