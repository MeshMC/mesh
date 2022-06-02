package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.cow;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.cow.EntityMooshroom;

public class EntityMooshroomMesh<T extends net.minecraft.entity.passive.EntityMooshroom> extends EntityCowMesh<T> implements EntityMooshroom {
    public EntityMooshroomMesh(T value) {
        super(value);
    }
}
