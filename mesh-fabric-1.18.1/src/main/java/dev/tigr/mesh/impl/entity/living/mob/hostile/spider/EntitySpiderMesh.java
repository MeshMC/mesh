package dev.tigr.mesh.impl.entity.living.mob.hostile.spider;

import dev.tigr.mesh.api.entity.living.mob.hostile.spider.EntitySpider;
import dev.tigr.mesh.impl.entity.living.mob.hostile.EntityHostileMesh;
import net.minecraft.entity.mob.SpiderEntity;

public class EntitySpiderMesh<T extends SpiderEntity> extends EntityHostileMesh<T> implements EntitySpider<T> {
    public EntitySpiderMesh(T value) {
        super(value);
    }
}
