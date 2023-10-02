package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerInteractEntityC2SPacket.InteractAtHandler.class)
public interface InteractAtHandlerAccessor {
    @Accessor("pos")
    Vec3d getPos();

    @Mutable
    @Accessor("pos")
    void setPos(Vec3d pos);

    @Accessor("hand")
    Hand getHand();

    @Mutable
    @Accessor("hand")
    void setHand(Hand hand);
}
