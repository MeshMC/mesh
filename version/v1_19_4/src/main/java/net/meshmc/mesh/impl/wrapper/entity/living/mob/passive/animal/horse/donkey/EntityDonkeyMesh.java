package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.EntityDonkey;
import net.minecraft.entity.passive.DonkeyEntity;

public class EntityDonkeyMesh<T extends DonkeyEntity> extends EntityAbstractDonkeyMesh<T> implements EntityDonkey {
    public EntityDonkeyMesh(T value) {
        super(value);
    }
}
