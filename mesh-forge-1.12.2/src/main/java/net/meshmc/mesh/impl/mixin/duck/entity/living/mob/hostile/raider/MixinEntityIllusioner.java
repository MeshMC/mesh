package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.raider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.monster.EntityIllusionIllager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityIllusionIllager.class)
public abstract class MixinEntityIllusioner extends MixinEntityIllagerSpellcaster implements EntityIllusioner {
}
