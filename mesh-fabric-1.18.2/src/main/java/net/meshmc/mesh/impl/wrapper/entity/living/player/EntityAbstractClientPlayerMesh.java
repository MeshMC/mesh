package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityAbstractClientPlayer;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public class EntityAbstractClientPlayerMesh<T extends AbstractClientPlayerEntity> extends EntityPlayerMesh<T> implements EntityAbstractClientPlayer {
    public EntityAbstractClientPlayerMesh(T value) {
        super(value);
    }
}
