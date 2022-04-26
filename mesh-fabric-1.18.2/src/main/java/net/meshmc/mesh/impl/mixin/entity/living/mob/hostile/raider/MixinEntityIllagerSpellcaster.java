package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityIllagerSpellcaster;
import net.minecraft.entity.mob.SpellcastingIllagerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpellcastingIllagerEntity.class)
public abstract class MixinEntityIllagerSpellcaster extends MixinEntityRaiderAbstract implements EntityIllagerSpellcaster {
}
