package dev.tigr.mesh.impl.entity.living.mob.hostile.guardian;

import dev.tigr.mesh.api.entity.living.mob.hostile.guardian.EntityGuardianElder;
import net.minecraft.entity.monster.EntityElderGuardian;

public class EntityGuardianElderMesh<T extends EntityElderGuardian> extends EntityGuardianMesh<T> implements EntityGuardianElder<T> {
    public EntityGuardianElderMesh(T value) {
        super(value);
    }
}
