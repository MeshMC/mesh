package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityZoglin;
import net.minecraft.entity.mob.ZoglinEntity;

public class EntityZoglinMesh<T extends ZoglinEntity> extends EntityHostileMesh<T> implements EntityZoglin<T> {
    public EntityZoglinMesh(T value) {
        super(value);
    }
}
