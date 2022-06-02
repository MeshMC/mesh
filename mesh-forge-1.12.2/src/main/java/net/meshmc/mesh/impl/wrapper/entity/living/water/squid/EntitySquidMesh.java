package net.meshmc.mesh.impl.wrapper.entity.living.water.squid;

import net.meshmc.mesh.api.entity.living.water.squid.EntitySquid;
import net.meshmc.mesh.impl.wrapper.entity.living.water.EntityWaterCreatureMesh;

public class EntitySquidMesh<T extends net.minecraft.entity.passive.EntitySquid> extends EntityWaterCreatureMesh<T> implements EntitySquid {
    public EntitySquidMesh(T value) {
        super(value);
    }
}
