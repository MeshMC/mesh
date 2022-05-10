package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityWitch;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.WitchEntity;

/**
 * EntityWitch is a raider in later versions, but in 1.12 Witch does not extend the same class as other Illagers
 */
public class EntityWitchMesh<T extends WitchEntity> extends EntityHostileMesh<T> implements EntityWitch {
    public EntityWitchMesh(T value) {
        super(value);
    }
}
