package dev.tigr.mesh.impl.world;

import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.world.ClientWorld;
import dev.tigr.mesh.impl.entity.EntityMesh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigermouthbear 1/16/22
 */
public class ClientWorldMesh extends WorldMesh<net.minecraft.client.world.ClientWorld> implements ClientWorld<net.minecraft.client.world.ClientWorld> {
    public ClientWorldMesh(net.minecraft.client.world.ClientWorld value) {
        super(value);
    }

    @Override
    public List<Entity<?>> getEntities() {
        List<Entity<?>> list = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: getMeshValue().getEntities()) {
            list.add(EntityMesh.fromEntity(entity));
        }
        return list;
    }
}
