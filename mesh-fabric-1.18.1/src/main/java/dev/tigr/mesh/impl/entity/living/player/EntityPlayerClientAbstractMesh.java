package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerClientAbstract;

public class EntityPlayerClientAbstractMesh<T extends net.minecraft.client.network.AbstractClientPlayerEntity> extends EntityPlayerMesh<T> implements EntityPlayerClientAbstract<T> {
    public EntityPlayerClientAbstractMesh(T value) {
        super(value);
    }
}
