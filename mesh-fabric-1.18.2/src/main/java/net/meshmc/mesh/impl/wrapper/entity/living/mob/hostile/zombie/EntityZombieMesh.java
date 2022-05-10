package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombie;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.ZombieEntity;

public class EntityZombieMesh<T extends ZombieEntity> extends EntityHostileMesh<T> implements EntityZombie {
    public EntityZombieMesh(T value) {
        super(value);
    }
}
