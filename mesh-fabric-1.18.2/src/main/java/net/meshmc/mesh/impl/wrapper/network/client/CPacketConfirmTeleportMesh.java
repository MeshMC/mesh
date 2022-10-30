package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketConfirmTeleport;
import net.meshmc.mesh.impl.mixin.accessors.packet.TeleportConfirmC2SPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.c2s.play.TeleportConfirmC2SPacket;

public class CPacketConfirmTeleportMesh extends PacketMesh.Client<TeleportConfirmC2SPacket> implements CPacketConfirmTeleport {
    public CPacketConfirmTeleportMesh(TeleportConfirmC2SPacket value) {
        super(value);
    }

    @Override
    public C2S getType() {
        return C2S.ConfirmTeleport;
    }

    @Override
    public int getTeleportId() {
        return getMeshValue().getTeleportId();
    }

    @Override
    public void setTeleportId(int id) {
        ((TeleportConfirmC2SPacketAccessor) getMeshValue()).setTeleportId(id);
    }
}
