package net.meshmc.mesh.impl.wrapper.world;

import net.meshmc.mesh.api.entity.Entity;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.impl.wrapper.collections.EntityIterable;

public class ClientWorldMesh<T extends net.minecraft.client.world.ClientWorld> extends WorldMesh<T> implements ClientWorld {
    public ClientWorldMesh(T value) {
        super(value);
    }

    @Override
    public Iterable<Entity> getLoadedEntities() {
        return new EntityIterable(getMeshValue().getEntities());
    }
}
