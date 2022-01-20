package dev.tigr.mesh.impl.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.api.entity.living.mob.hostile.zombie.EntityZombieVillager;

public class EntityZombieVillagerMesh<T extends net.minecraft.entity.mob.ZombieVillagerEntity> extends EntityZombieMesh<T> implements EntityZombieVillager<T> {
    public EntityZombieVillagerMesh(T value) {
        super(value);
    }
}
