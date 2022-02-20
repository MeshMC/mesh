package net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.spider;

import net.meshmc.mesh.impl.mixin.entity.living.mob.hostile.MixinEntityHostile;
import net.meshmc.mesh.api.entity.living.mob.hostile.spider.EntitySpider;
import net.minecraft.entity.mob.SpiderEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SpiderEntity.class)
public abstract class MixinEntitySpider extends MixinEntityHostile implements EntitySpider {
}
