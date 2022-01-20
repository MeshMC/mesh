package dev.tigr.mesh.impl.entity.living.mob;

import dev.tigr.mesh.api.entity.living.mob.EntityMob;
import dev.tigr.mesh.impl.entity.living.LivingEntityMesh;
import net.minecraft.entity.mob.PathAwareEntity;

public class EntityMobMesh<T extends PathAwareEntity> extends LivingEntityMesh<T> implements EntityMob<T> {
    public EntityMobMesh(T value) {
        super(value);
    }
}
