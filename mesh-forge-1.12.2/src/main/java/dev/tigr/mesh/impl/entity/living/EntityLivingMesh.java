package dev.tigr.mesh.impl.entity.living;

import dev.tigr.mesh.api.entity.living.EntityLiving;
import dev.tigr.mesh.impl.entity.EntityMesh;
import net.minecraft.entity.EntityLivingBase;

public class EntityLivingMesh<T extends EntityLivingBase> extends EntityMesh<T> implements EntityLiving<T> {
    public EntityLivingMesh(T value) {
        super(value);
    }
}
