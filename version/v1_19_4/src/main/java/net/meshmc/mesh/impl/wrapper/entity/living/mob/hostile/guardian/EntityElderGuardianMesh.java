package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.guardian;

import net.meshmc.mesh.api.entity.living.mob.hostile.guardian.EntityElderGuardian;
import net.minecraft.entity.mob.ElderGuardianEntity;

public class EntityElderGuardianMesh<T extends ElderGuardianEntity> extends EntityGuardianMesh<T> implements EntityElderGuardian {
    public EntityElderGuardianMesh(T value) {
        super(value);
    }
}
