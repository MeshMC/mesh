package net.meshmc.mesh.impl.wrapper.entity.living;

import net.meshmc.mesh.api.entity.living.EntityLiving;
import net.meshmc.mesh.impl.wrapper.entity.EntityMesh;
import net.minecraft.entity.LivingEntity;

public class EntityLivingMesh<T extends LivingEntity> extends EntityMesh<T> implements EntityLiving {
    public EntityLivingMesh(T value) {
        super(value);
    }
}
