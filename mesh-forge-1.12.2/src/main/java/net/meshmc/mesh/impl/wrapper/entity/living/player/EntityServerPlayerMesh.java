package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityServerPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class EntityServerPlayerMesh<T extends EntityPlayerMP> extends EntityPlayerMesh<T> implements EntityServerPlayer {
    public EntityServerPlayerMesh(T value) {
        super(value);
    }
}
