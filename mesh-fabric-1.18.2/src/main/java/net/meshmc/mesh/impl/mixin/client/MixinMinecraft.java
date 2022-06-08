package net.meshmc.mesh.impl.mixin.client;

import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.render.Framebuffer;
import net.meshmc.mesh.api.render.TextRenderer;
import net.meshmc.mesh.api.util.Profiler;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.util.ScreenAdapter;
import net.meshmc.mesh.impl.wrapper.entity.living.player.EntityClientPlayerMesh;
import net.meshmc.mesh.impl.wrapper.util.ProfilerMesh;
import net.meshmc.mesh.impl.wrapper.world.ClientWorldMesh;
import net.meshmc.mesh.util.render.Resolution;
import net.meshmc.mesh.util.render.Screen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.Window;
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
    @Shadow @Final private net.minecraft.client.gl.Framebuffer framebuffer;

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
        return (ClientWorld) Mappings.world(world);
    }

    @Override
    public void setWorld(ClientWorld world) {
        this.world = ((ClientWorldMesh<?>) world).getMeshValue();
    }

    @Override
    public EntityClientPlayer getPlayer() {
        return (EntityClientPlayer) Mappings.entity(player);
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        this.player = ((EntityClientPlayerMesh<?>) player).getMeshValue();
    }

    @Override
    public void openScreen(Screen screen) {
        ((MinecraftClient)((Object) this)).setScreen(new ScreenAdapter(screen));
    }

    @Override
    public void closeScreen() {
        ((MinecraftClient)((Object) this)).setScreen(null);
    }

    @Override
    public Resolution getResolution() {
        Window window = ((MinecraftClient)((Object) this)).getWindow();
        return new Resolution(
                window.getWidth(),
                window.getHeight(),
                window.getScaledWidth(),
                window.getScaledHeight(),
                window.getScaleFactor()
        );
    }

    @Override
    public Framebuffer getFramebuffer() {
        return (Framebuffer) this.framebuffer;
    }
}
