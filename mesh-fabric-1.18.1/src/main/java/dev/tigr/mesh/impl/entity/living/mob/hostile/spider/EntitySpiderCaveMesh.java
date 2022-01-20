package dev.tigr.mesh.impl.entity.living.mob.hostile.spider;

import dev.tigr.mesh.api.entity.living.mob.hostile.spider.EntitySpiderCave;
import net.minecraft.entity.mob.CaveSpiderEntity;

public class EntitySpiderCaveMesh<T extends CaveSpiderEntity> extends EntitySpiderMesh<T> implements EntitySpiderCave<T> {
    public EntitySpiderCaveMesh(T value) {
        super(value);
    }
}
