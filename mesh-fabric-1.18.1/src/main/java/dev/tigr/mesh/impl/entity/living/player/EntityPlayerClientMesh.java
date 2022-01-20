package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerClient;

public class EntityPlayerClientMesh<T extends net.minecraft.client.network.ClientPlayerEntity> extends EntityPlayerClientAbstractMesh<T> implements EntityPlayerClient<T> {
    public EntityPlayerClientMesh(T value) {
        super(value);
    }
}
