package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.piglin;

import net.meshmc.mesh.api.entity.living.mob.hostile.piglin.EntityPiglinBrute;
import net.minecraft.entity.mob.PiglinBruteEntity;

public class EntityPiglinBruteMesh<T extends PiglinBruteEntity> extends EntityPiglinAbstractMesh<T> implements EntityPiglinBrute {
    public EntityPiglinBruteMesh(T value) {
        super(value);
    }
}
