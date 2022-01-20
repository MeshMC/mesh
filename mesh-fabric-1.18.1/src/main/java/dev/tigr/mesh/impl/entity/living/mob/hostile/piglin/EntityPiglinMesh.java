package dev.tigr.mesh.impl.entity.living.mob.hostile.piglin;

import dev.tigr.mesh.api.entity.living.mob.hostile.piglin.EntityPiglin;
import net.minecraft.entity.mob.PiglinEntity;

public class EntityPiglinMesh<T extends PiglinEntity> extends EntityPiglinAbstractMesh<T> implements EntityPiglin<T> {
    public EntityPiglinMesh(T value) {
        super(value);
    }
}
