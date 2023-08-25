package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.EntityHorse;

public class EntityHorseMesh<T extends net.minecraft.entity.passive.EntityHorse> extends EntityHorseBaseMesh<T> implements EntityHorse {
    public EntityHorseMesh(T value) {
        super(value);
    }
}
