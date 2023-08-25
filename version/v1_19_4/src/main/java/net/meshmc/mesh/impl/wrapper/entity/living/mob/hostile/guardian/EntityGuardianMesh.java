package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.api.entity.living.mob.hostile.guardian.EntityGuardian;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.GuardianEntity;

public class EntityGuardianMesh<T extends GuardianEntity> extends EntityHostileMesh<T> implements EntityGuardian {
    public EntityGuardianMesh(T value) {
        super(value);
    }
}
