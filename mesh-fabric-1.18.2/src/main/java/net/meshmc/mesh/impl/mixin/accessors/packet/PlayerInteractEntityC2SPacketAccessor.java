package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerInteractEntityC2SPacket.class)
public interface PlayerInteractEntityC2SPacketAccessor {
    @Accessor("entityId")
    int getEntityId();

    @Mutable
    @Accessor("entityId")
    void setEntityId(int value);

    @Accessor("type")
    PlayerInteractEntityC2SPacket.InteractTypeHandler getType();

    @Mutable
    @Accessor("type")
    void setType(PlayerInteractEntityC2SPacket.InteractTypeHandler handler);

    @Accessor("playerSneaking")
    boolean isPlayerSneaking();

    @Mutable
    @Accessor("playerSneaking")
    void setPlayerSneaking(boolean value);

    @Accessor("ATTACK")
    static PlayerInteractEntityC2SPacket.InteractTypeHandler getAttack() {
        throw new RuntimeException();
    }
}
