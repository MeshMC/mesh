package dev.tigr.mesh.impl.world;

import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.world.ClientWorld;
import dev.tigr.mesh.impl.entity.EntityMesh;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * @author Tigermouthbear 1/16/22
 */
public class ClientWorldMesh extends WorldMesh<WorldClient> implements ClientWorld<WorldClient> {
    public ClientWorldMesh(WorldClient value) {
        super(value);
    }

    @Override
    public Iterable<Entity<?>> getEntities() {
        return new EntityMesh.EntityIterable(getMeshValue().loadedEntityList);
    }
}
