package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityVindicator;

public class EntityVindicatorMesh<T extends net.minecraft.entity.monster.EntityVindicator> extends EntityRaiderAbstractMesh<T> implements EntityVindicator<T> {
    public EntityVindicatorMesh(T value) {
        super(value);
    }
}
