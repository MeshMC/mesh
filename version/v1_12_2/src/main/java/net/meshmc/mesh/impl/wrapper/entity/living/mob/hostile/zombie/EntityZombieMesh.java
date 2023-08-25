package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombie;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;

public class EntityZombieMesh<T extends net.minecraft.entity.monster.EntityZombie> extends EntityHostileMesh<T> implements EntityZombie {
    public EntityZombieMesh(T value) {
        super(value);
    }
}
