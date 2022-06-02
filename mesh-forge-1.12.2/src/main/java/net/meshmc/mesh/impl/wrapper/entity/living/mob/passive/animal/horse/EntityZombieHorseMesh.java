package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.EntityZombieHorse;

public class EntityZombieHorseMesh<T extends net.minecraft.entity.passive.EntityZombieHorse> extends EntityHorseBaseMesh<T> implements EntityZombieHorse {
    public EntityZombieHorseMesh(T value) {
        super(value);
    }
}
