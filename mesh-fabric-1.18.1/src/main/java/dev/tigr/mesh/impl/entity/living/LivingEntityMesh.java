package dev.tigr.mesh.impl.entity.living;

import dev.tigr.mesh.api.entity.living.EntityLiving;
import dev.tigr.mesh.impl.entity.EntityMesh;

public class LivingEntityMesh<T extends net.minecraft.entity.LivingEntity> extends EntityMesh<T> implements EntityLiving<T> {
    public LivingEntityMesh(T value) {
        super(value);
    }
}
