package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityAbstractClientPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;

public class EntityAbstractClientPlayerMesh<T extends AbstractClientPlayer> extends EntityPlayerMesh<T> implements EntityAbstractClientPlayer {
    public EntityAbstractClientPlayerMesh(T value) {
        super(value);
    }
}
