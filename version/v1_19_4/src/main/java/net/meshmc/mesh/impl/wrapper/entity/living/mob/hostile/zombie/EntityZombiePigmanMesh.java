package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;

public class EntityZombiePigmanMesh<T extends ZombifiedPiglinEntity> extends EntityZombieMesh<T> implements EntityZombiePigman {
    public EntityZombiePigmanMesh(T value) {
        super(value);
    }
}
