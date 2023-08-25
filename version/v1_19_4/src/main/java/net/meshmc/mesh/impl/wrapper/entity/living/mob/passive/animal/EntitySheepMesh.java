package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntitySheep;
import net.minecraft.entity.passive.SheepEntity;

public class EntitySheepMesh<T extends SheepEntity> extends EntityAnimalMesh<T> implements EntitySheep {
    public EntitySheepMesh(T value) {
        super(value);
    }
}
