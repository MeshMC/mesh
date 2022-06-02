package net.meshmc.mesh.impl.wrapper.entity.living.water;

import net.meshmc.mesh.api.entity.living.water.EntityWaterCreature;
import net.meshmc.mesh.impl.wrapper.entity.living.EntityLivingMesh;
import net.minecraft.entity.mob.WaterCreatureEntity;

public class EntityWaterCreatureMesh<T extends WaterCreatureEntity> extends EntityLivingMesh<T> implements EntityWaterCreature {
    public EntityWaterCreatureMesh(T value) {
        super(value);
    }
}
