package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityFox;
import net.minecraft.entity.passive.FoxEntity;

public class EntityFoxMesh<T extends FoxEntity> extends EntityAnimalMesh<T> implements EntityFox {
    public EntityFoxMesh(T value) {
        super(value);
    }
}
