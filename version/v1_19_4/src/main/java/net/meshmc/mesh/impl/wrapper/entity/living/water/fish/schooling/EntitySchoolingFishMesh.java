package net.meshmc.mesh.impl.wrapper.entity.living.water.fish.schooling;

import net.meshmc.mesh.api.entity.living.water.fish.schooling.EntitySchoolingFish;
import net.meshmc.mesh.impl.wrapper.entity.living.water.fish.EntityFishMesh;
import net.minecraft.entity.passive.SchoolingFishEntity;

public class EntitySchoolingFishMesh<T extends SchoolingFishEntity> extends EntityFishMesh<T> implements EntitySchoolingFish {
    public EntitySchoolingFishMesh(T value) {
        super(value);
    }
}
