package net.meshmc.mesh.impl.wrapper.network;

import io.netty.buffer.ByteBuf;
import net.meshmc.mesh.api.AbstractMesh;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class PacketMesh<T extends Packet<?>> extends AbstractMesh<T> implements net.meshmc.mesh.api.network.Packet {
    public PacketMesh(T value) {
        super(value);
    }

    @Override
    public void write(ByteBuf buf) {
        try {
            getMeshValue().writePacketData(new PacketBuffer(buf));
        } catch(IOException ignored) {
        }
    }

    public abstract static class Client<T extends Packet<?>> extends PacketMesh<T> implements net.meshmc.mesh.api.network.Packet.Client {
        public Client(T value) {
            super(value);
        }
    }

    public abstract static class Server<T extends Packet<?>> extends PacketMesh<T> implements net.meshmc.mesh.api.network.Packet.Server {
        public Server(T value) {
            super(value);
        }
    }
}
