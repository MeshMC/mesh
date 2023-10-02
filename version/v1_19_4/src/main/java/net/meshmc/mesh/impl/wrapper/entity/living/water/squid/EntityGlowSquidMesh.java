package net.meshmc.mesh.impl.wrapper.entity.living.water.squid;

import net.meshmc.mesh.api.entity.living.water.squid.EntityGlowSquid;
import net.minecraft.entity.passive.GlowSquidEntity;

public class EntityGlowSquidMesh<T extends GlowSquidEntity> extends EntitySquidMesh<T> implements EntityGlowSquid {
    public EntityGlowSquidMesh(T value) {
        super(value);
    }
}
