package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityVindicator;
import net.minecraft.entity.mob.VindicatorEntity;

public class EntityVindicatorMesh<T extends VindicatorEntity> extends EntityRaiderAbstractMesh<T> implements EntityVindicator {
    public EntityVindicatorMesh(T value) {
        super(value);
    }
}
