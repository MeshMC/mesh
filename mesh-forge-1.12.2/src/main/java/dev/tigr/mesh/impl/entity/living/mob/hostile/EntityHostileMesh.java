package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityHostile;
import dev.tigr.mesh.impl.entity.living.mob.EntityMobMesh;
import net.minecraft.entity.monster.EntityMob;

public class EntityHostileMesh<T extends EntityMob> extends EntityMobMesh<T> implements EntityHostile<T> {
    public EntityHostileMesh(T value) {
        super(value);
    }
}
