package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketConfirmTeleport;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketConfirmTeleportAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;

public class CPacketConfirmTeleportMesh extends PacketMesh.Client<net.minecraft.network.play.client.CPacketConfirmTeleport> implements CPacketConfirmTeleport {
    public CPacketConfirmTeleportMesh(net.minecraft.network.play.client.CPacketConfirmTeleport value) {
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
        ((CPacketConfirmTeleportAccessor) getMeshValue()).setTeleportId(id);
    }
}
