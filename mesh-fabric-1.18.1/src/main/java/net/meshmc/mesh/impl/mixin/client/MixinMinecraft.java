package net.meshmc.mesh.impl.mixin.client;

import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.render.TextRenderer;
import net.meshmc.mesh.api.util.Profiler;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.impl.wrapper.util.ProfilerMesh;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MinecraftClient.class)
public class MixinMinecraft implements Minecraft {
    @Shadow private net.minecraft.util.profiler.Profiler profiler;
    @Shadow @Final public net.minecraft.client.font.TextRenderer textRenderer;
    @Mutable @Shadow @Final private net.minecraft.client.util.Session session;
    @Shadow @Nullable public net.minecraft.client.world.ClientWorld world;
    @Shadow @Nullable public ClientPlayerEntity player;

    @Override
    public Profiler<?> getProfiler() {
        return new ProfilerMesh(profiler);
    }

    @Override
    public TextRenderer getTextRenderer() {
        return (TextRenderer) textRenderer;
    }

    @Override
    public Session getSession() {
        return (Session) session;
    }

    @Override
    public void setSession(Session session) {
        this.session = (net.minecraft.client.util.Session) session;
    }

    @Override
    public ClientWorld getWorld() {
        return (ClientWorld) world;
    }

    @Override
    public void setWorld(ClientWorld world) {
        this.world = (net.minecraft.client.world.ClientWorld) world;
    }

    @Override
    public EntityClientPlayer getPlayer() {
        return (EntityClientPlayer) player;
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        this.player = (ClientPlayerEntity) player;
    }
}
