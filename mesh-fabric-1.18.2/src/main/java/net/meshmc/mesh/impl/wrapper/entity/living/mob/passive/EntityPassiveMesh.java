package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive;

import net.meshmc.mesh.api.entity.living.mob.passive.EntityPassive;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.EntityMobMesh;
import net.minecraft.entity.passive.PassiveEntity;

public class EntityPassiveMesh<T extends PassiveEntity> extends EntityMobMesh<T> implements EntityPassive {
    public EntityPassiveMesh(T value) {
        super(value);
    }
}
