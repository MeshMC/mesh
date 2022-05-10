package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile;

import net.meshmc.mesh.api.entity.living.mob.hostile.EntitySilverfish;

public class EntitySilverfishMesh<T extends net.minecraft.entity.monster.EntitySilverfish> extends EntityHostileMesh<T> implements EntitySilverfish {
    public EntitySilverfishMesh(T value) {
        super(value);
    }
}
