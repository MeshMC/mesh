package dev.tigr.mesh.impl.world;

import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.world.ClientWorld;
import dev.tigr.mesh.impl.entity.EntityMesh;

/**
 * @author Tigermouthbear 1/16/22
 */
public class ClientWorldMesh extends WorldMesh<net.minecraft.client.world.ClientWorld> implements ClientWorld<net.minecraft.client.world.ClientWorld> {
    public ClientWorldMesh(net.minecraft.client.world.ClientWorld value) {
        super(value);
    }

    @Override
    public Iterable<Entity<?>> getEntities() {
        return new EntityMesh.EntityIterable(getMeshValue().getEntities());
    }
}
