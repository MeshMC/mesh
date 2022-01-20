package dev.tigr.mesh.impl.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.api.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.monster.EntityPigZombie;

public class EntityZombiePigmanMesh<T extends EntityPigZombie> extends EntityZombieMesh<T> implements EntityZombiePigman<T> {
    public EntityZombiePigmanMesh(T value) {
        super(value);
    }
}
