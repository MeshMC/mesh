package net.meshmc.mesh.impl.mixin.duck.entity.living.mob.hostile.spider;

import net.meshmc.mesh.impl.mixininterface.entity.living.mob.hostile.spider.EntityCaveSpider;
import net.minecraft.entity.mob.CaveSpiderEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CaveSpiderEntity.class)
public abstract class MixinEntityCaveSpider extends MixinEntitySpider implements EntityCaveSpider {
}
