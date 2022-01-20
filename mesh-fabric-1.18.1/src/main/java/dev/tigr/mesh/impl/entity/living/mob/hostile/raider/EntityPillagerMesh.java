package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityPillager;
import net.minecraft.entity.mob.PillagerEntity;

public class EntityPillagerMesh<T extends PillagerEntity> extends EntityRaiderAbstractMesh<T> implements EntityPillager<T> {
    public EntityPillagerMesh(T value) {
        super(value);
    }
}
