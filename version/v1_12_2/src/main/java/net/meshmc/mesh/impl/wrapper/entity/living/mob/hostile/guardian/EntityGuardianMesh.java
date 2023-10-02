package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.api.entity.living.mob.hostile.guardian.EntityGuardian;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;

public class EntityGuardianMesh<T extends net.minecraft.entity.monster.EntityGuardian> extends EntityHostileMesh<T> implements EntityGuardian {
    public EntityGuardianMesh(T value) {
        super(value);
    }
}
