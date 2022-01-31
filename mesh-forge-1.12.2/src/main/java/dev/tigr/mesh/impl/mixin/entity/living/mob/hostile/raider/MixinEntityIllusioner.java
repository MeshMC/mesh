package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityIllusioner;
import net.minecraft.entity.monster.EntityIllusionIllager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityIllusionIllager.class)
public abstract class MixinEntityIllusioner extends MixinEntityIllagerSpellcaster implements EntityIllusioner {
}
