package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.monster.EntityIllusionIllager;

public class EntityIllusionerMesh<T extends EntityIllusionIllager> extends EntityIllagerSpellcasterMesh<T> implements EntityIllusioner {
    public EntityIllusionerMesh(T value) {
        super(value);
    }
}
