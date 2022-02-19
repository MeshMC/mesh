package net.meshmc.mesh.event.events.client;

import net.meshmc.mesh.event.MeshEvent;

public class PacketEvent extends MeshEvent {
    Object packet;

    private PacketEvent(Object packet, Era era) {
        super(packet.toString(), era);
        this.packet = packet;
    }

    public Object getPacket() {
        return packet;
    }

    public static class Sent extends PacketEvent {
        public Sent(Object packet, Era era) {
            super(packet, era);
        }
    }

    public static class Received extends PacketEvent {
        public Received(Object packet, Era era) {
            super(packet, era);
        }
    }
}
