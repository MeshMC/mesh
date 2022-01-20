package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.monster.EntityIllusionIllager;

public class EntityIllusionerMesh<T extends EntityIllusionIllager> extends EntityIllagerSpellcasterMesh<T> implements EntityIllusioner<T> {
    public EntityIllusionerMesh(T value) {
        super(value);
    }
}
