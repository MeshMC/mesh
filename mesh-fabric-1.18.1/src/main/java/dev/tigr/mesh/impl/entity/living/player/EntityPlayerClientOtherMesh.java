package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerClientOther;

public class EntityPlayerClientOtherMesh<T extends net.minecraft.client.network.OtherClientPlayerEntity> extends EntityPlayerClientAbstractMesh<T> implements EntityPlayerClientOther<T> {
    public EntityPlayerClientOtherMesh(T value) {
        super(value);
    }
}
