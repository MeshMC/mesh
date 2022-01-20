package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerServer;

public class EntityPlayerServerMesh<T extends net.minecraft.server.network.ServerPlayerEntity> extends EntityPlayerMesh<T> implements EntityPlayerServer<T> {
    public EntityPlayerServerMesh(T value) {
        super(value);
    }
}
