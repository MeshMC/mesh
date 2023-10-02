package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider;

import net.meshmc.mesh.api.entity.living.mob.hostile.spider.EntityCaveSpider;

public class EntityCaveSpiderMesh<T extends net.minecraft.entity.monster.EntityCaveSpider> extends EntitySpiderMesh<T> implements EntityCaveSpider {
    public EntityCaveSpiderMesh(T value) {
        super(value);
    }
}
