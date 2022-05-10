package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.piglin;

import net.meshmc.mesh.api.entity.living.mob.hostile.piglin.EntityPiglinAbstract;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.AbstractPiglinEntity;

public class EntityPiglinAbstractMesh<T extends AbstractPiglinEntity> extends EntityHostileMesh<T> implements EntityPiglinAbstract {
    public EntityPiglinAbstractMesh(T value) {
        super(value);
    }
}
