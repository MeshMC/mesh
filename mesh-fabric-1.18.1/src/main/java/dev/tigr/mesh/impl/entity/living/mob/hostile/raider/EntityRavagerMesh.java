package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityRavager;
import net.minecraft.entity.mob.RavagerEntity;

public class EntityRavagerMesh<T extends RavagerEntity> extends EntityRaiderAbstractMesh<T> implements EntityRavager<T> {
    public EntityRavagerMesh(T value) {
        super(value);
    }
}
