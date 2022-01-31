package dev.tigr.mesh.impl.mixininterface.world;

import dev.tigr.mesh.impl.mixininterface.entity.Entity;

public interface ClientWorld {
    Iterable<Entity> getLoadedEntities();
}
