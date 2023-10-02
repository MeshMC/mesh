package net.meshmc.mesh.impl.wrapper.entity.living.water.fish.schooling;

import net.meshmc.mesh.api.entity.living.water.fish.schooling.EntityTropicalFish;
import net.minecraft.entity.passive.TropicalFishEntity;

public class EntityTropicalFishMesh<T extends TropicalFishEntity> extends EntitySchoolingFishMesh<T> implements EntityTropicalFish {
    public EntityTropicalFishMesh(T value) {
        super(value);
    }
}
