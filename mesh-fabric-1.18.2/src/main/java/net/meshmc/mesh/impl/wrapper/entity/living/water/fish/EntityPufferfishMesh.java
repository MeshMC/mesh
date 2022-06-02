package net.meshmc.mesh.impl.wrapper.entity.living.water.fish;

import net.meshmc.mesh.api.entity.living.water.fish.EntityPufferfish;
import net.minecraft.entity.passive.PufferfishEntity;

public class EntityPufferfishMesh<T extends PufferfishEntity> extends EntityFishMesh<T> implements EntityPufferfish {
    public EntityPufferfishMesh(T value) {
        super(value);
    }
}
