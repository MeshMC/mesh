package net.meshmc.mesh.impl.wrapper.network;

import net.meshmc.mesh.api.AbstractMesh;
import net.minecraft.network.listener.PacketListener;

public class PacketListenerMesh extends AbstractMesh<PacketListener> implements net.meshmc.mesh.api.network.PacketListener {
    public PacketListenerMesh(PacketListener value) {
        super(value);
    }
}
