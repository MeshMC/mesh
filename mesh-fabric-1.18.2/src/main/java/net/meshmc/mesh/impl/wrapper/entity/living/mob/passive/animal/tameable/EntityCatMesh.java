package net.meshmc.mesh.impl.wrapper.entity.living.mob.passive.animal.tameable;

import net.meshmc.mesh.api.entity.living.mob.passive.animal.tameable.EntityCat;
import net.minecraft.entity.passive.CatEntity;

public class EntityCatMesh<T extends CatEntity> extends EntityTameableMesh<T> implements EntityCat {
    public EntityCatMesh(T value) {
        super(value);
    }
}
