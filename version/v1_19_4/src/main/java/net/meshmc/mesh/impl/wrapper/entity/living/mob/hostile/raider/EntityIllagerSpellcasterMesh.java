package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityIllagerSpellcaster;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;

public class EntityIllagerSpellcasterMesh<T extends SpellcastingIllagerEntity> extends EntityRaiderAbstractMesh<T> implements EntityIllagerSpellcaster {
    public EntityIllagerSpellcasterMesh(T value) {
        super(value);
    }
}
