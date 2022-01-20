package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.mob.IllusionerEntity;

public class EntityIllusionerMesh<T extends IllusionerEntity> extends EntityIllagerSpellcasterMesh<T> implements EntityIllusioner<T> {
    public EntityIllusionerMesh(T value) {
        super(value);
    }
}
