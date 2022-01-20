package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerClientAbstract;
import net.minecraft.client.entity.AbstractClientPlayer;

public class EntityPlayerClientAbstractMesh<T extends AbstractClientPlayer> extends EntityPlayerMesh<T> implements EntityPlayerClientAbstract<T> {
    public EntityPlayerClientAbstractMesh(T value) {
        super(value);
    }
}
