package net.meshmc.mesh.api.world;

import net.meshmc.mesh.api.entity.Entity;

public interface ClientWorld extends World {
    Iterable<Entity> getLoadedEntities();
}
