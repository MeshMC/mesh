package dev.tigr.mesh.impl.entity.living.mob.hostile.guardian;

import dev.tigr.mesh.api.entity.living.mob.hostile.guardian.EntityGuardian;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;

public class EntityGuardianMesh<T extends net.minecraft.entity.monster.EntityGuardian> extends EntityHostileMesh<T> implements EntityGuardian<T> {
    public EntityGuardianMesh(T value) {
        super(value);
    }
}
