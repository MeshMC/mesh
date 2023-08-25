package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.monster.EntityPigZombie;

public class EntityZombiePigmanMesh<T extends EntityPigZombie> extends EntityZombieMesh<T> implements EntityZombiePigman {
    public EntityZombiePigmanMesh(T value) {
        super(value);
    }
}
