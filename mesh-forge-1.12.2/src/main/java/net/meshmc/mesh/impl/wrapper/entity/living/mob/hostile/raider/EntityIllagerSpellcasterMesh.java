package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityIllagerSpellcaster;
import net.minecraft.entity.monster.EntitySpellcasterIllager;

public class EntityIllagerSpellcasterMesh<T extends EntitySpellcasterIllager> extends EntityRaiderAbstractMesh<T> implements EntityIllagerSpellcaster {
    public EntityIllagerSpellcasterMesh(T value) {
        super(value);
    }
}
