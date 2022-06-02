package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive;

import net.meshmc.mesh.api.entity.living.mob.passive.EntityVillager;
import net.minecraft.entity.passive.VillagerEntity;

public class EntityVillagerMesh<T extends VillagerEntity> extends EntityPassiveMesh<T> implements EntityVillager {
    public EntityVillagerMesh(T value) {
        super(value);
    }
}
