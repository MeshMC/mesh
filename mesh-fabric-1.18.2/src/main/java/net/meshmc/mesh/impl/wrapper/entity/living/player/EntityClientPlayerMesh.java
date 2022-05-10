package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.minecraft.client.network.ClientPlayerEntity;

public class EntityClientPlayerMesh<T extends ClientPlayerEntity> extends EntityAbstractClientPlayerMesh<T> implements EntityClientPlayer {
    public EntityClientPlayerMesh(T value) {
        super(value);
    }
}
