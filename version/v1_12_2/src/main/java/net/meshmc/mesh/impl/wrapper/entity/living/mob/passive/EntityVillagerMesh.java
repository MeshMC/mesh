package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive;

import net.meshmc.mesh.api.entity.living.mob.passive.EntityVillager;

public class EntityVillagerMesh<T extends net.minecraft.entity.passive.EntityVillager> extends EntityPassiveMesh<T> implements EntityVillager {
    public EntityVillagerMesh(T value) {
        super(value);
    }
}
