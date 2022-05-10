package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityCreeper;
import net.minecraft.entity.mob.CreeperEntity;

public class EntityCreeperMesh<T extends CreeperEntity> extends EntityHostileMesh<T> implements EntityCreeper {
    public EntityCreeperMesh(T value) {
        super(value);
    }
}
