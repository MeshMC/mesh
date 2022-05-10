package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider;

import net.meshmc.mesh.api.entity.living.mob.hostile.spider.EntitySpider;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.SpiderEntity;

public class EntitySpiderMesh<T extends SpiderEntity> extends EntityHostileMesh<T> implements EntitySpider {
    public EntitySpiderMesh(T value) {
        super(value);
    }
}
