package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityVindicator;

public class EntityVindicatorMesh<T extends net.minecraft.entity.monster.EntityVindicator> extends EntityRaiderAbstractMesh<T> implements EntityVindicator {
    public EntityVindicatorMesh(T value) {
        super(value);
    }
}
