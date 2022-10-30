package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketInput.class)
public interface CPacketInputAccessor {
    @Accessor("strafeSpeed")
    void setSideways(float value);

    @Accessor("forwardSpeed")
    void setForward(float value);

    @Accessor("jumping")
    void setJumping(boolean value);

    @Accessor("sneaking")
    void setSneaking(boolean value);
}
