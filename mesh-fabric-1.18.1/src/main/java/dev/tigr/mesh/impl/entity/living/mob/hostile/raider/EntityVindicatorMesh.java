package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityVindicator;
import net.minecraft.entity.mob.VindicatorEntity;

public class EntityVindicatorMesh<T extends VindicatorEntity> extends EntityRaiderAbstractMesh<T> implements EntityVindicator<T> {
    public EntityVindicatorMesh(T value) {
        super(value);
    }
}
