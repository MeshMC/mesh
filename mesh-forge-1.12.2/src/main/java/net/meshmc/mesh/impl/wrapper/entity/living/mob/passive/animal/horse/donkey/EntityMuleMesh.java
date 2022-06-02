package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.EntityMule;

public class EntityMuleMesh<T extends net.minecraft.entity.passive.EntityMule> extends EntityAbstractDonkeyMesh<T> implements EntityMule {
    public EntityMuleMesh(T value) {
        super(value);
    }
}
