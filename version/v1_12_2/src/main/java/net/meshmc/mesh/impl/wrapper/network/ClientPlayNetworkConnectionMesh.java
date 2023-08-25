package net.meshmc.mesh.impl.wrapper.network;

import net.meshmc.mesh.api.network.ClientPlayNetworkConnection;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;

public class ClientPlayNetworkConnectionMesh extends ClientPlayNetworkConnection<NetHandlerPlayClient> {
    public ClientPlayNetworkConnectionMesh(NetHandlerPlayClient value) {
        super(value);
    }

    @Override
    public NetworkConnection<?> getNetworkConnection() {
        return new NetworkConnectionMesh(getMeshValue().getNetworkManager());
    }

    @Override
    public void sendPacket(Object packet) {
        getMeshValue().sendPacket((Packet<?>) packet);
    }
}
