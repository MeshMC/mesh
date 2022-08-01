package net.meshmc.mesh.api.network;

import net.meshmc.mesh.api.AbstractMesh;

public abstract class ClientPlayNetworkConnection<T> extends AbstractMesh<T> {
    public ClientPlayNetworkConnection(T value) {
        super(value);
    }

    public abstract NetworkConnection<?> getNetworkConnection();

    public abstract void sendPacket(Object packet);
}
