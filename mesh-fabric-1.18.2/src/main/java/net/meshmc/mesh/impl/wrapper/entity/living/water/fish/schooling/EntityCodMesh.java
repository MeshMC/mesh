package net.meshmc.mesh.impl.wrapper.entity.living.water.fish.schooling;

import net.meshmc.mesh.api.entity.living.water.fish.schooling.EntityCod;
import net.minecraft.entity.passive.CodEntity;

public class EntityCodMesh<T extends CodEntity> extends EntitySchoolingFishMesh<T> implements EntityCod {
    public EntityCodMesh(T value) {
        super(value);
    }
}
