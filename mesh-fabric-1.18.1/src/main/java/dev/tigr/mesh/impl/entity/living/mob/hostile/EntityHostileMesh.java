package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityHostile;
import dev.tigr.mesh.impl.entity.living.mob.EntityMobMesh;

public class EntityHostileMesh<T extends net.minecraft.entity.mob.HostileEntity> extends EntityMobMesh<T> implements EntityHostile<T> {
    public EntityHostileMesh(T value) {
        super(value);
    }
}
