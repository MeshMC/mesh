package net.meshmc.mesh.impl.mixininterface.world;

import net.meshmc.mesh.impl.mixininterface.entity.Entity;

public interface ClientWorld {
    Iterable<Entity> getLoadedEntities();
}
