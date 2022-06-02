package net.meshmc.mesh.impl.wrapper.entity.living.water;

import net.meshmc.mesh.api.entity.living.water.EntityDolphin;
import net.minecraft.entity.passive.DolphinEntity;

public class EntityDolphinMesh<T extends DolphinEntity> extends EntityWaterCreatureMesh<T> implements EntityDolphin {
    public EntityDolphinMesh(T value) {
        super(value);
    }
}
