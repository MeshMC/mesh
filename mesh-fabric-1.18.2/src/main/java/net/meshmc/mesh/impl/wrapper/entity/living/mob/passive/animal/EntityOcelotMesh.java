package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityOcelot;
import net.minecraft.entity.passive.OcelotEntity;

public class EntityOcelotMesh<T extends OcelotEntity> extends EntityAnimalMesh<T> implements EntityOcelot {
    public EntityOcelotMesh(T value) {
        super(value);
    }
}
