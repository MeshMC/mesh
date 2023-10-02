package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.EntityDonkey;

public class EntityDonkeyMesh<T extends net.minecraft.entity.passive.EntityDonkey> extends EntityAbstractDonkeyMesh<T> implements EntityDonkey {
    public EntityDonkeyMesh(T value) {
        super(value);
    }
}
