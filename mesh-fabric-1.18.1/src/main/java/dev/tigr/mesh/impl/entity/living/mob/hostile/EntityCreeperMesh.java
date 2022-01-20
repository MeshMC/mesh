package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityCreeper;
import net.minecraft.entity.mob.CreeperEntity;

public class EntityCreeperMesh<T extends CreeperEntity> extends EntityHostileMesh<T> implements EntityCreeper<T> {
    public EntityCreeperMesh(T value) {
        super(value);
    }
}
