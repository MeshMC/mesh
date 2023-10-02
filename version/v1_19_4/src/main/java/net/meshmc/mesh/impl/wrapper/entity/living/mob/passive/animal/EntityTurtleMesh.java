package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.EntityTurtle;
import net.minecraft.entity.passive.TurtleEntity;

public class EntityTurtleMesh<T extends TurtleEntity> extends EntityAnimalMesh<T> implements EntityTurtle {
    public EntityTurtleMesh(T value) {
        super(value);
    }
}
