package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.raider;

import dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.raider.EntityRaiderAbstract;
import net.minecraft.entity.monster.AbstractIllager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractIllager.class)
public abstract class MixinEntityRaiderAbstract extends MixinEntityHostile implements EntityRaiderAbstract {
}
