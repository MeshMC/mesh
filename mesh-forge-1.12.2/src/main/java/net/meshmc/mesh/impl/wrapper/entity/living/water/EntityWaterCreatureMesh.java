package net.meshmc.mesh.impl.wrapper.entity.living.water;

import net.meshmc.mesh.api.entity.living.water.EntityWaterCreature;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.minecraft.entity.passive.EntityWaterMob;

public class EntityWaterCreatureMesh<T extends EntityWaterMob> extends EntityLivingMesh<T> implements EntityWaterCreature {
    public EntityWaterCreatureMesh(T value) {
        super(value);
    }
}
