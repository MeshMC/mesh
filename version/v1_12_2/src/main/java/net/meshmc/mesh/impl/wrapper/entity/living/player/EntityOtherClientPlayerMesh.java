package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityOtherClientPlayer;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public class EntityOtherClientPlayerMesh<T extends EntityOtherPlayerMP> extends EntityAbstractClientPlayerMesh<T> implements EntityOtherClientPlayer {
    public EntityOtherClientPlayerMesh(T value) {
        super(value);
    }
}
