package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.cow;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.cow.EntityMooshroom;
import net.minecraft.entity.passive.MooshroomEntity;

public class EntityMooshroomMesh<T extends MooshroomEntity> extends EntityCowMesh<T> implements EntityMooshroom {
    public EntityMooshroomMesh(T value) {
        super(value);
    }
}
