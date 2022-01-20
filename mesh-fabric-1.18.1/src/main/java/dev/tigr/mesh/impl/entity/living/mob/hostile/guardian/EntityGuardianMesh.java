package dev.tigr.mesh.impl.entity.living.mob.hostile.guardian;

import dev.tigr.mesh.api.entity.living.mob.hostile.guardian.EntityGuardian;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.GuardianEntity;

public class EntityGuardianMesh<T extends GuardianEntity> extends EntityHostileMesh<T> implements EntityGuardian<T> {
    public EntityGuardianMesh(T value) {
        super(value);
    }
}
