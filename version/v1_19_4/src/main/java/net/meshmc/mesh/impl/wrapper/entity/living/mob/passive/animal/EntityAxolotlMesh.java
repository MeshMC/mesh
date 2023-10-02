package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityAxolotl;
import net.minecraft.entity.passive.AxolotlEntity;

public class EntityAxolotlMesh<T extends AxolotlEntity> extends EntityAnimalMesh<T> implements EntityAxolotl {
    public EntityAxolotlMesh(T value) {
        super(value);
    }
}
