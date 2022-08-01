package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.network.ClientPlayNetworkConnection;
import net.meshmc.mesh.impl.wrapper.network.ClientPlayNetworkConnectionMesh;
import net.minecraft.client.network.ClientPlayerEntity;

public class EntityClientPlayerMesh<T extends ClientPlayerEntity> extends EntityAbstractClientPlayerMesh<T> implements EntityClientPlayer {
    public EntityClientPlayerMesh(T value) {
        super(value);
    }

    @Override
    public ClientPlayNetworkConnection<?> getNetworkConnection() {
        return new ClientPlayNetworkConnectionMesh(getMeshValue().networkHandler);
    }
}
