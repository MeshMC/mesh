package dev.tigr.mesh.impl.entity.living.mob;

import dev.tigr.mesh.api.entity.living.mob.EntityMob;
import dev.tigr.mesh.impl.entity.living.EntityLivingMesh;
import net.minecraft.entity.EntityCreature;

public class EntityMobMesh<T extends EntityCreature> extends EntityLivingMesh<T> implements EntityMob<T> {
    public EntityMobMesh(T value) {
        super(value);
    }
}
