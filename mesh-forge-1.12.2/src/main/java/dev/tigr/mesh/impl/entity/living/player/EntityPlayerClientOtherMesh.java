package dev.tigr.mesh.impl.entity.living.player;

import dev.tigr.mesh.api.entity.living.player.EntityPlayerClientOther;
import net.minecraft.client.entity.EntityOtherPlayerMP;

public class EntityPlayerClientOtherMesh<T extends EntityOtherPlayerMP> extends EntityPlayerClientAbstractMesh<T> implements EntityPlayerClientOther<T> {
    public EntityPlayerClientOtherMesh(T value) {
        super(value);
    }
}
