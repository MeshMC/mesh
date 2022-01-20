package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerClient;
import net.minecraft.client.entity.EntityPlayerSP;

public class EntityPlayerClientMesh<T extends EntityPlayerSP> extends EntityPlayerClientAbstractMesh<T> implements EntityPlayerClient<T> {
    public EntityPlayerClientMesh(T value) {
        super(value);
    }
}
