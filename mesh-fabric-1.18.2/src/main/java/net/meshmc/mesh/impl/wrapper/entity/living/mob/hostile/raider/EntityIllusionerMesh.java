package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.mob.IllusionerEntity;

public class EntityIllusionerMesh<T extends IllusionerEntity> extends EntityIllagerSpellcasterMesh<T> implements EntityIllusioner {
    public EntityIllusionerMesh(T value) {
        super(value);
    }
}
