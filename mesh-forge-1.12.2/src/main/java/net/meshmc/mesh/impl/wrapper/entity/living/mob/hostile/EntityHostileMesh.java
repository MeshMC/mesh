package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityHostile;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.EntityMobMesh;
import net.minecraft.entity.monster.EntityMob;

public class EntityHostileMesh<T extends EntityMob> extends EntityMobMesh<T> implements EntityHostile {
    public EntityHostileMesh(T value) {
        super(value);
    }
}
