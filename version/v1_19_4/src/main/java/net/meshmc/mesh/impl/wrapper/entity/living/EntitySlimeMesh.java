package net.meshmc.mesh.impl.wrapper.entity.living;

import net.meshmc.mesh.api.entity.living.EntitySlime;
import net.minecraft.entity.mob.SlimeEntity;

public class EntitySlimeMesh<T extends SlimeEntity> extends EntityLivingMesh<T> implements EntitySlime {
    public EntitySlimeMesh(T value) {
        super(value);
    }
}
