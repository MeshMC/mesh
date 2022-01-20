package dev.tigr.mesh.impl.entity.living.mob.hostile.piglin;

import dev.tigr.mesh.api.entity.living.mob.hostile.piglin.EntityPiglinBrute;
import net.minecraft.entity.mob.PiglinBruteEntity;

public class EntityPiglinBruteMesh<T extends PiglinBruteEntity> extends EntityPiglinAbstractMesh<T> implements EntityPiglinBrute<T> {
    public EntityPiglinBruteMesh(T value) {
        super(value);
    }
}
