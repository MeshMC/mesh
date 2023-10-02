package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.EntityWolf;

public class EntityWolfMesh<T extends net.minecraft.entity.passive.EntityWolf> extends EntityTameableMesh<T> implements EntityWolf {
    public EntityWolfMesh(T value) {
        super(value);
    }
}
