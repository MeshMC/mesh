package dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.spider;

import dev.tigr.mesh.impl.mixin.duck.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.spider.EntitySpider;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntitySpider.class)
public abstract class MixinEntitySpider extends MixinEntityHostile implements EntitySpider {
}
