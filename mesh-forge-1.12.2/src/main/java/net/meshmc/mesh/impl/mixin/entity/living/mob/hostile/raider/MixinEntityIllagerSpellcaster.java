package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.raider;

import net.meshmc.mesh.api.entity.living.mob.hostile.raider.EntityIllagerSpellcaster;
import net.minecraft.entity.monster.EntitySpellcasterIllager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntitySpellcasterIllager.class)
public abstract class MixinEntityIllagerSpellcaster extends MixinEntityRaiderAbstract implements EntityIllagerSpellcaster {
}
