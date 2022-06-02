package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntitySheep;

public class EntitySheepMesh<T extends net.minecraft.entity.passive.EntitySheep> extends EntityAnimalMesh<T> implements EntitySheep {
    public EntitySheepMesh(T value) {
        super(value);
    }
}
