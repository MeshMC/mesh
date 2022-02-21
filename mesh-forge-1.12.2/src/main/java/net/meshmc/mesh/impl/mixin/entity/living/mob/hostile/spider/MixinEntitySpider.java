package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.spider;

import net.meshmc.mesh.api.entity.living.mob.hostile.spider.EntitySpider;
import net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntitySpider.class)
public abstract class MixinEntitySpider extends MixinEntityHostile implements EntitySpider {
}
