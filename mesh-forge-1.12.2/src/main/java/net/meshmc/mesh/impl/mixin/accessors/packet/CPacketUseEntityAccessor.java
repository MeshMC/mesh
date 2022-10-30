package net.meshmc.mesh.impl.mixin.accessors.packet;

import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketUseEntity.class)
public interface CPacketUseEntityAccessor {
    @Accessor("entityId")
    int getEntityId();

    @Accessor("entityId")
    void setEntityId(int value);

    @Accessor("hitVec")
    void setHitVec(Vec3d vec);

    @Accessor("hand")
    void setHand(EnumHand hand);

    @Accessor("action")
    void setType(CPacketUseEntity.Action action);
}
