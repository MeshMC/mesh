package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.spider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.spider.EntityCaveSpider;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(net.minecraft.entity.monster.EntityCaveSpider.class)
public abstract class MixinEntityCaveSpider extends MixinEntitySpider implements EntityCaveSpider {
}
