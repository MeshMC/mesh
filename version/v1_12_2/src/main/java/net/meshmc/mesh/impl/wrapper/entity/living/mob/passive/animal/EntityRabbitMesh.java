package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityRabbit;

public class EntityRabbitMesh<T extends net.minecraft.entity.passive.EntityRabbit> extends EntityAnimalMesh<T> implements EntityRabbit {
    public EntityRabbitMesh(T value) {
        super(value);
    }
}
