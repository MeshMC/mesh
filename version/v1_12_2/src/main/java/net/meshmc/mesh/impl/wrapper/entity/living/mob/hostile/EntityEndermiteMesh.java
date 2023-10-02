package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityEndermite;

public class EntityEndermiteMesh<T extends net.minecraft.entity.monster.EntityEndermite> extends EntityHostileMesh<T> implements EntityEndermite {
    public EntityEndermiteMesh(T value) {
        super(value);
    }
}
