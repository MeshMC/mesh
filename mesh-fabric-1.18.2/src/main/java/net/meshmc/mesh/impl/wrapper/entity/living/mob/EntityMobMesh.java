package net.meshmc.mesh.impl.wrapper.entity.living.mob;

import net.meshmc.mesh.api.entity.living.mob.EntityMob;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.minecraft.entity.mob.PathAwareEntity;

public class EntityMobMesh<T extends PathAwareEntity> extends EntityLivingMesh<T> implements EntityMob {
    public EntityMobMesh(T value) {
        super(value);
    }
}
