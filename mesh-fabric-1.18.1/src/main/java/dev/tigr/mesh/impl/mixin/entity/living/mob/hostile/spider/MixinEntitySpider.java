package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.spider;

import dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.spider.EntitySpider;
import net.minecraft.entity.mob.SpiderEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpiderEntity.class)
public abstract class MixinEntitySpider extends MixinEntityHostile implements EntitySpider {
}
