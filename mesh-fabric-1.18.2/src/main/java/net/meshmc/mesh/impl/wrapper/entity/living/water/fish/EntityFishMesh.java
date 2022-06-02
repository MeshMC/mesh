package net.meshmc.mesh.impl.wrapper.entity.living.water.fish;

import net.meshmc.mesh.api.entity.living.water.fish.EntityFish;
import net.meshmc.mesh.impl.wrapper.entity.living.water.EntityWaterCreatureMesh;
import net.minecraft.entity.passive.FishEntity;

public class EntityFishMesh<T extends FishEntity> extends EntityWaterCreatureMesh<T> implements EntityFish {
    public EntityFishMesh(T value) {
        super(value);
    }
}
