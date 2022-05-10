package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombieVillager;

public class EntityZombieVillagerMesh<T extends net.minecraft.entity.monster.EntityZombieVillager> extends EntityZombieMesh<T> implements EntityZombieVillager {
    public EntityZombieVillagerMesh(T value) {
        super(value);
    }
}
