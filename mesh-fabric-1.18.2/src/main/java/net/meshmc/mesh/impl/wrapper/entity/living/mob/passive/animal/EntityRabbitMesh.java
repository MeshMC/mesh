package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityRabbit;
import net.minecraft.entity.passive.RabbitEntity;

public class EntityRabbitMesh<T extends RabbitEntity> extends EntityAnimalMesh<T> implements EntityRabbit {
    public EntityRabbitMesh(T value) {
        super(value);
    }
}
