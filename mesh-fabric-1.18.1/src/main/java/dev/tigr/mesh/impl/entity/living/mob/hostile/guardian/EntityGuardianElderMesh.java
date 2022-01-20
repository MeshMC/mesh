package dev.tigr.mesh.impl.entity.living.mob.hostile.guardian;

import dev.tigr.mesh.api.entity.living.mob.hostile.guardian.EntityGuardianElder;
import net.minecraft.entity.mob.ElderGuardianEntity;

public class EntityGuardianElderMesh<T extends ElderGuardianEntity> extends EntityGuardianMesh<T> implements EntityGuardianElder<T> {
    public EntityGuardianElderMesh(T value) {
        super(value);
    }
}
