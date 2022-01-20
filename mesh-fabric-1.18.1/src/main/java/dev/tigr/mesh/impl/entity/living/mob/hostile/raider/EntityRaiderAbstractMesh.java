package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityRaiderAbstract;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.raid.RaiderEntity;

public class EntityRaiderAbstractMesh<T extends RaiderEntity> extends EntityHostileMesh<T> implements EntityRaiderAbstract<T> {
    public EntityRaiderAbstractMesh(T value) {
        super(value);
    }
}
