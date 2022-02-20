package net.meshmc.mesh.event.events.client;

import net.meshmc.mesh.event.MeshEvent;

/**
 * Posted when the client sends and receives a packet
 * Is cancellable
 */
public class PacketEvent extends MeshEvent {
    public enum Type {
        SENT,
        RECEIVED
    }

    private final Type type;
    private final Object packet;

    private PacketEvent(Type type, Object packet, Era era) {
        super("packet_" + type.name() + "_" + packet.getClass().getSimpleName(), era);
        this.type = type;
        this.packet = packet;
    }

    public Type getType() {
        return type;
    }

    public Object getPacket() {
        return packet;
    }

    public static class Sent extends PacketEvent {
        public Sent(Object packet, Era era) {
            super(Type.SENT, packet, era);
        }
    }

    public static class Received extends PacketEvent {
        public Received(Object packet, Era era) {
            super(Type.RECEIVED, packet, era);
        }
    }
}
