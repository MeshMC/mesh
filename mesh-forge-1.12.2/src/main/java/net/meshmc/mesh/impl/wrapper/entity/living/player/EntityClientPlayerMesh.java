package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;

public class EntityClientPlayerMesh<T extends EntityPlayerSP> extends EntityAbstractClientPlayerMesh<T> implements EntityClientPlayer {
    public EntityClientPlayerMesh(T value) {
        super(value);
    }
}
