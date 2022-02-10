package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityIllagerSpellcaster;
import net.minecraft.entity.monster.EntitySpellcasterIllager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntitySpellcasterIllager.class)
public abstract class MixinEntityIllagerSpellcaster extends MixinEntityRaiderAbstract implements EntityIllagerSpellcaster {
}
