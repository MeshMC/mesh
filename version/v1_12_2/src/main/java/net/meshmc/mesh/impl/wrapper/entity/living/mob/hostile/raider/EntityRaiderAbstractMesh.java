package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityRaiderAbstract;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.monster.AbstractIllager;

public class EntityRaiderAbstractMesh<T extends AbstractIllager> extends EntityHostileMesh<T> implements EntityRaiderAbstract {
    public EntityRaiderAbstractMesh(T value) {
        super(value);
    }
}
