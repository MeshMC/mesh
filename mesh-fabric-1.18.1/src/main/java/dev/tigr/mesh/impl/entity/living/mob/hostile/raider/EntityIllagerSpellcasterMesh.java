package dev.tigr.mesh.impl.entity.living.mob.hostile.raider;

import dev.tigr.mesh.api.entity.living.mob.hostile.raider.EntityIllagerSpellcaster;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;

public class EntityIllagerSpellcasterMesh<T extends SpellcastingIllagerEntity> extends EntityRaiderAbstractMesh<T> implements EntityIllagerSpellcaster<T> {
    public EntityIllagerSpellcasterMesh(T value) {
        super(value);
    }
}
