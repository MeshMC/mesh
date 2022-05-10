package net.meshmc.mesh.impl.wrapper.entity.living;

import net.meshmc.mesh.api.entity.living.EntityLiving;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.minecraft.entity.EntityLivingBase;

public class EntityLivingMesh<T extends EntityLivingBase> extends EntityMesh<T> implements EntityLiving {
    public EntityLivingMesh(T value) {
        super(value);
    }
}
