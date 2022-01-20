package dev.tigr.mesh.impl.entity.living.mob.hostile;

import dev.tigr.mesh.api.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.monster.EntityGiantZombie;

public class EntityGiantMesh<T extends EntityGiantZombie> extends EntityHostileMesh<T> implements EntityGiant<T> {
    public EntityGiantMesh(T value) {
        super(value);
    }
}
