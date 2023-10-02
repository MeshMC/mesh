package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive;

import net.meshmc.mesh.api.entity.living.mob.passive.EntityWanderingTrader;
import net.minecraft.entity.passive.WanderingTraderEntity;

public class EntityWanderingTraderMesh<T extends WanderingTraderEntity> extends EntityPassiveMesh<T> implements EntityWanderingTrader {
    public EntityWanderingTraderMesh(T value) {
        super(value);
    }
}
