package net.meshmc.mesh.impl.wrapper.entity.living.mob;

import net.meshmc.mesh.api.entity.living.mob.EntityMob;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.minecraft.entity.EntityCreature;

public class EntityMobMesh<T extends EntityCreature> extends EntityLivingMesh<T> implements EntityMob {
    public EntityMobMesh(T value) {
        super(value);
    }
}
