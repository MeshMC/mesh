package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityPig;

public class EntityPigMesh<T extends net.minecraft.entity.passive.EntityPig> extends EntityAnimalMesh<T> implements EntityPig {
    public EntityPigMesh(T value) {
        super(value);
    }
}
