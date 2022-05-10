package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityServerPlayer;
import net.minecraft.server.network.ServerPlayerEntity;

public class EntityServerPlayerMesh<T extends ServerPlayerEntity> extends EntityPlayerMesh<T> implements EntityServerPlayer {
    public EntityServerPlayerMesh(T value) {
        super(value);
    }
}
