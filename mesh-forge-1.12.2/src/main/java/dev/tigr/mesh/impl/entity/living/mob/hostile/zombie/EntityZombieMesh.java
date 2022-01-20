package dev.tigr.mesh.impl.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.api.entity.living.mob.hostile.zombie.EntityZombie;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;

public class EntityZombieMesh<T extends net.minecraft.entity.monster.EntityZombie> extends EntityHostileMesh<T> implements EntityZombie<T> {
    public EntityZombieMesh(T value) {
        super(value);
    }
}
