package net.meshmc.mesh.impl.wrapper.network;

import net.meshmc.mesh.api.network.ClientPlayNetworkConnection;
import net.meshmc.mesh.api.network.NetworkConnection;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.Packet;

public class ClientPlayNetworkConnectionMesh extends ClientPlayNetworkConnection<ClientPlayNetworkHandler> {
    public ClientPlayNetworkConnectionMesh(net.minecraft.client.network.ClientPlayNetworkHandler value) {
        super(value);
    }

    @Override
    public NetworkConnection<?> getNetworkConnection() {
        return new NetworkConnectionMesh(getMeshValue().getConnection());
    }

    @Override
    public void sendPacket(Object packet) {
        getMeshValue().sendPacket((Packet<?>) packet);
    }
}
