package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.horse.donkey.llama;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.horse.donkey.llama.EntityTraderLlama;
import net.minecraft.entity.passive.TraderLlamaEntity;

public class EntityTraderLlamaMesh<T extends TraderLlamaEntity> extends EntityLlamaMesh<T> implements EntityTraderLlama {
    public EntityTraderLlamaMesh(T value) {
        super(value);
    }
}
