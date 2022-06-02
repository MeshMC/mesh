package net.meshmc.mesh.impl.wrapper.entity.living.water.fish.schooling;

import net.meshmc.mesh.api.entity.living.water.fish.schooling.EntitySalmon;
import net.minecraft.entity.passive.SalmonEntity;

public class EntitySalmonMesh<T extends SalmonEntity> extends EntitySchoolingFishMesh<T> implements EntitySalmon {
    public EntitySalmonMesh(T value) {
        super(value);
    }
}
