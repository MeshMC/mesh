package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombieVillager;
import net.minecraft.entity.mob.ZombieVillagerEntity;

public class EntityZombieVillagerMesh<T extends ZombieVillagerEntity> extends EntityZombieMesh<T> implements EntityZombieVillager {
    public EntityZombieVillagerMesh(T value) {
        super(value);
    }
}
