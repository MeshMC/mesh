package net.meshmc.mesh.impl.wrapper.network;

import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.network.PacketListener;
import net.minecraft.network.INetHandler;

public class PacketListenerMesh extends AbstractMesh<INetHandler> implements PacketListener {
    public PacketListenerMesh(INetHandler value) {
        super(value);
    }
}
