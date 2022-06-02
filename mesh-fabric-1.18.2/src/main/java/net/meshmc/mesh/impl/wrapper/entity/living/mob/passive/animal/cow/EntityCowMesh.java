package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.cow;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.cow.EntityCow;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.EntityAnimalMesh;
import net.minecraft.entity.passive.CowEntity;

public class EntityCowMesh<T extends CowEntity> extends EntityAnimalMesh<T> implements EntityCow {
    public EntityCowMesh(T value) {
        super(value);
    }
}
