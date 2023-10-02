package net.meshmc.mesh.impl.wrapper.entity.living.water.squid;

import net.meshmc.mesh.api.entity.living.water.squid.EntitySquid;
import net.meshmc.mesh.impl.wrapper.entity.living.water.EntityWaterCreatureMesh;
import net.minecraft.entity.passive.SquidEntity;

public class EntitySquidMesh<T extends SquidEntity> extends EntityWaterCreatureMesh<T> implements EntitySquid {
    public EntitySquidMesh(T value) {
        super(value);
    }
}
