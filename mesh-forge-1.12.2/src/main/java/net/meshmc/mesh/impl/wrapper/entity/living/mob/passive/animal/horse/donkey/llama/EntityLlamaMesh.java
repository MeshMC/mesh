package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey.llama;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.llama.EntityLlama;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey.EntityAbstractDonkeyMesh;

public class EntityLlamaMesh<T extends net.minecraft.entity.passive.EntityLlama> extends EntityAbstractDonkeyMesh<T> implements EntityLlama {
    public EntityLlamaMesh(T value) {
        super(value);
    }
}
