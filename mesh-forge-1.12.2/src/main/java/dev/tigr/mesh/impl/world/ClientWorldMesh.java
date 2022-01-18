package dev.tigr.mesh.impl.world;

import dev.tigr.mesh.api.entity.Entity;
import dev.tigr.mesh.api.world.ClientWorld;
import dev.tigr.mesh.impl.entity.EntityMesh;
import net.minecraft.client.multiplayer.WorldClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigermouthbear 1/16/22
 */
public class ClientWorldMesh extends WorldMesh<WorldClient> implements ClientWorld<WorldClient> {
    public ClientWorldMesh(WorldClient value) {
        super(value);
    }

    @Override
    public List<Entity<?>> getEntities() {
        List<Entity<?>> list = new ArrayList<>();
        for(net.minecraft.entity.Entity entity: getMeshValue().loadedEntityList) {
            list.add(EntityMesh.fromEntity(entity));
        }
        return list;
    }
}
