package net.meshmc.mesh.impl.wrapper.world;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.impl.wrapper.collections.EntityIterable;
import net.minecraft.client.multiplayer.WorldClient;

public class ClientWorldMesh<T extends WorldClient> extends WorldMesh<T> implements ClientWorld {
    public ClientWorldMesh(T value) {
        super(value);
    }

    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new EntityIterable(getMeshValue().loadedEntityList);
    }
}
