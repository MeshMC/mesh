package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityCreeper;

public class EntityCreeperMesh<T extends net.minecraft.entity.monster.EntityCreeper> extends EntityHostileMesh<T> implements EntityCreeper {
    public EntityCreeperMesh(T value) {
        super(value);
    }
}
