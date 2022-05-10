package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.api.entity.living.mob.hostile.guardian.EntityElderGuardian;

public class EntityElderGuardianMesh<T extends net.minecraft.entity.monster.EntityElderGuardian> extends EntityGuardianMesh<T> implements EntityElderGuardian {
    public EntityElderGuardianMesh(T value) {
        super(value);
    }
}
