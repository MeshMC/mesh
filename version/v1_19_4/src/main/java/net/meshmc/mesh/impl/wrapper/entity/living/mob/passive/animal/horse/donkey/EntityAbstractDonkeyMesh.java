package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.EntityAbstractDonkey;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.EntityHorseBaseMesh;
import net.minecraft.entity.passive.AbstractDonkeyEntity;

public class EntityAbstractDonkeyMesh<T extends AbstractDonkeyEntity> extends EntityHorseBaseMesh<T> implements EntityAbstractDonkey {
    public EntityAbstractDonkeyMesh(T value) {
        super(value);
    }
}
