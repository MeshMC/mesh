package net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.spider;

import net.meshmc.mesh.api.entity.living.mob.hostile.spider.EntitySpider;
import net.meshmc.mesh.impl.wrapper.entity.living.mob.hostile.EntityHostileMesh;

public class EntitySpiderMesh<T extends net.minecraft.entity.monster.EntitySpider> extends EntityHostileMesh<T> implements EntitySpider {
    public EntitySpiderMesh(T value) {
        super(value);
    }
}
