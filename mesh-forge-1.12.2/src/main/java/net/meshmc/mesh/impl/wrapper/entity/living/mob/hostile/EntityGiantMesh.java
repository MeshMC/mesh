package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntityGiant;
import net.minecraft.entity.monster.EntityGiantZombie;

public class EntityGiantMesh<T extends EntityGiantZombie> extends EntityHostileMesh<T> implements EntityGiant {
    public EntityGiantMesh(T value) {
        super(value);
    }
}
