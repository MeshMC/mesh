package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityDrowned;
import net.minecraft.entity.mob.DrownedEntity;

public class EntityDrownedMesh<T extends DrownedEntity> extends EntityZombieMesh<T> implements EntityDrowned {
    public EntityDrownedMesh(T value) {
        super(value);
    }
}
