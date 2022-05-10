package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.zombie;

import net.meshmc.mesh.api.entity.living.mob.hostile.zombie.EntityHusk;

public class EntityHuskMesh<T extends net.minecraft.entity.monster.EntityHusk> extends EntityZombieMesh<T> implements EntityHusk {
    public EntityHuskMesh(T value) {
        super(value);
    }
}
