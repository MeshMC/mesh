package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityRavager;
import net.minecraft.entity.mob.RavagerEntity;

public class EntityRavagerMesh<T extends RavagerEntity> extends EntityRaiderAbstractMesh<T> implements EntityRavager {
    public EntityRavagerMesh(T value) {
        super(value);
    }
}
