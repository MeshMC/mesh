package dev.tigr.mesh.impl.entity.living.mob.hostile.zombie;

import dev.tigr.mesh.api.entity.living.mob.hostile.zombie.EntityZombiePigman;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;

public class EntityZombiePigmanMesh<T extends ZombifiedPiglinEntity> extends EntityZombieMesh<T> implements EntityZombiePigman<T> {
    public EntityZombiePigmanMesh(T value) {
        super(value);
    }
}
