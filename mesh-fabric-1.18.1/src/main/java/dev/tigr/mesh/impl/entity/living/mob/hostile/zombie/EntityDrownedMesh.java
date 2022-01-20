package dev.tigr.mesh.impl.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.api.entity.living.mob.hostile.zombie.EntityDrowned;

public class EntityDrownedMesh<T extends net.minecraft.entity.mob.DrownedEntity> extends EntityZombieMesh<T> implements EntityDrowned<T> {
    public EntityDrownedMesh(T value) {
        super(value);
    }
}
