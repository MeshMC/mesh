package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.piglin;

import net.meshmc.mesh.api.entity.living.mob.hostile.piglin.EntityPiglin;
import net.minecraft.entity.mob.PiglinEntity;

public class EntityPiglinMesh<T extends PiglinEntity> extends EntityPiglinAbstractMesh<T> implements EntityPiglin {
    public EntityPiglinMesh(T value) {
        super(value);
    }
}
