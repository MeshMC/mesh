package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.EntityMule;
import net.minecraft.entity.passive.MuleEntity;

public class EntityMuleMesh<T extends MuleEntity> extends EntityAbstractDonkeyMesh<T> implements EntityMule {
    public EntityMuleMesh(T value) {
        super(value);
    }
}
