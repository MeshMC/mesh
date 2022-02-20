package net.meshmc.mesh.api.world;

import net.meshmc.mesh.api.entity.Entity;

public interface ClientWorld {
    Iterable<Entity> getLoadedEntities();
}
