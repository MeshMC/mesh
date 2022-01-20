package dev.tigr.mesh.impl.entity.living.mob.hostile.piglin;

import dev.tigr.mesh.api.entity.living.mob.hostile.piglin.EntityPiglinAbstract;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.AbstractPiglinEntity;

public class EntityPiglinAbstractMesh<T extends AbstractPiglinEntity> extends EntityHostileMesh<T> implements EntityPiglinAbstract<T> {
    public EntityPiglinAbstractMesh(T value) {
        super(value);
    }
}
