package net.meshmc.mesh.api.entity.living.player;

import net.meshmc.mesh.api.network.ClientPlayNetworkConnection;

public interface EntityClientPlayer extends EntityAbstractClientPlayer {
    ClientPlayNetworkConnection<?> getNetworkConnection();
}
