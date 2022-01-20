package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerServer;
import net.minecraft.entity.player.EntityPlayerMP;

public class EntityPlayerServerMesh<T extends EntityPlayerMP> extends EntityPlayerMesh<T> implements EntityPlayerServer<T> {
    public EntityPlayerServerMesh(T value) {
        super(value);
    }
}
