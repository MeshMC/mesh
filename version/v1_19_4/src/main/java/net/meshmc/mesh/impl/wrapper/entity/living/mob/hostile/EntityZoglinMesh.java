package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityZoglin;
import net.minecraft.entity.mob.ZoglinEntity;

public class EntityZoglinMesh<T extends ZoglinEntity> extends EntityHostileMesh<T> implements EntityZoglin {
    public EntityZoglinMesh(T value) {
        super(value);
    }
}
