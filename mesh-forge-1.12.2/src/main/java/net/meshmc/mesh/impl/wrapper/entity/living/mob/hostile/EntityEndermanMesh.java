package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityEnderman;

public class EntityEndermanMesh<T extends net.minecraft.entity.monster.EntityEnderman> extends EntityHostileMesh<T> implements EntityEnderman {
    public EntityEndermanMesh(T value) {
        super(value);
    }
}
