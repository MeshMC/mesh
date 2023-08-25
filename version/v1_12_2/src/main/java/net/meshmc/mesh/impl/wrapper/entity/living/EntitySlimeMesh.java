package net.meshmc.mesh.impl.wrapper.entity.living;

import net.meshmc.mesh.api.entity.living.EntitySlime;

public class EntitySlimeMesh<T extends net.minecraft.entity.monster.EntitySlime> extends EntityLivingMesh<T> implements EntitySlime {
    public EntitySlimeMesh(T value) {
        super(value);
    }
}
