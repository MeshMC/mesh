package dev.tigr.mesh.impl.mixin.entity.living.mob.hostile.spider;

import dev.tigr.mesh.impl.mixininterface.entity.living.mob.hostile.spider.EntityCaveSpider;
import net.minecraft.entity.mob.CaveSpiderEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CaveSpiderEntity.class)
public abstract class MixinEntityCaveSpider extends MixinEntitySpider implements EntityCaveSpider {
}
