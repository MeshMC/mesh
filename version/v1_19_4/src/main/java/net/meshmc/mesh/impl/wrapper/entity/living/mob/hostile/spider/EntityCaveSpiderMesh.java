package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider;

import net.meshmc.mesh.api.entity.living.mob.hostile.spider.EntityCaveSpider;
import net.minecraft.entity.mob.CaveSpiderEntity;

public class EntityCaveSpiderMesh<T extends CaveSpiderEntity> extends EntitySpiderMesh<T> implements EntityCaveSpider {
    public EntityCaveSpiderMesh(T value) {
        super(value);
    }
}
