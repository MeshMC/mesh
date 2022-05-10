package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityPillager;
import net.minecraft.entity.mob.PillagerEntity;

public class EntityPillagerMesh<T extends PillagerEntity> extends EntityRaiderAbstractMesh<T> implements EntityPillager {
    public EntityPillagerMesh(T value) {
        super(value);
    }
}
