package net.meshmc.mesh.impl.mixin.accessors;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * @author Tigermouthbear 1/10/22
 */
@Mixin(Minecraft.class)
public interface MinecraftAccessor {
    @Accessor("session")
    void setSession(Session session);
}
