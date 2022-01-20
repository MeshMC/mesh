package dev.tigr.mesh.impl.entity.living.mob.hostile.spider;

import dev.tigr.mesh.api.entity.living.mob.hostile.spider.EntitySpiderCave;
import net.minecraft.entity.monster.EntityCaveSpider;

public class EntitySpiderCaveMesh<T extends EntityCaveSpider> extends EntitySpiderMesh<T> implements EntitySpiderCave<T> {
    public EntitySpiderCaveMesh(T value) {
        super(value);
    }
}
