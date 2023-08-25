package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.EntityZombieHorse;
import net.minecraft.entity.mob.ZombieHorseEntity;

public class EntityZombieHorseMesh<T extends ZombieHorseEntity> extends EntityHorseBaseMesh<T> implements EntityZombieHorse {
    public EntityZombieHorseMesh(T value) {
        super(value);
    }
}
