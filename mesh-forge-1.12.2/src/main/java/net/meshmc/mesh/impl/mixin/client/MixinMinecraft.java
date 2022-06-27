package net.meshmc.mesh.impl.mixin.client;

import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.render.buffer.BufferRenderer;
import net.meshmc.mesh.api.render.buffer.Framebuffer;
import net.meshmc.mesh.api.render.TextRenderer;
import net.meshmc.mesh.api.util.Profiler;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.util.ScreenAdapter;
import net.meshmc.mesh.impl.wrapper.entity.living.player.EntityClientPlayerMesh;
import net.meshmc.mesh.impl.wrapper.util.ProfilerMesh;
import net.meshmc.mesh.impl.wrapper.world.ClientWorldMesh;
import net.meshmc.mesh.util.render.Resolution;
import net.meshmc.mesh.api.render.Screen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft implements net.meshmc.mesh.api.client.Minecraft {
    @Shadow @Final public net.minecraft.profiler.Profiler profiler;
    @Shadow public FontRenderer fontRenderer;
    @Mutable @Shadow @Final private net.minecraft.util.Session session;
    @Shadow public WorldClient world;
    @Shadow public EntityPlayerSP player;
    @Shadow private net.minecraft.client.shader.Framebuffer framebuffer;

    @Shadow public abstract void resize(int width, int height);

    @Override
    public Profiler<?> getProfiler() {
        return new ProfilerMesh(profiler);
    }

    @Override
    public TextRenderer getTextRenderer() {
        return (TextRenderer) fontRenderer;
    }

    @Override
    public Session getSession() {
        return (Session) session;
    }

    @Override
    public void setSession(Session session) {
        this.session = (net.minecraft.util.Session) session;
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
        if(player == null) return null;
        return (EntityClientPlayer) Mappings.entity(player);
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        this.player = ((EntityClientPlayerMesh<?>) player).getMeshValue();
    }

    @Override
    public void openScreen(Screen screen) {
        ((Minecraft)((Object) this)).displayGuiScreen(new ScreenAdapter(screen));
    }

    @Override
    public void closeScreen() {
        ((Minecraft)((Object) this)).displayGuiScreen(null);
    }

    @Override
    public Resolution getResolution() {
        Minecraft mc = (Minecraft) ((Object) this);
        ScaledResolution scaledResolution = new ScaledResolution(mc);
        return new Resolution(
                mc.displayWidth,
                mc.displayHeight,
                scaledResolution.getScaledWidth(),
                scaledResolution.getScaledHeight(),
                scaledResolution.getScaleFactor()
        );
    }

    @Override
    public Framebuffer getFramebuffer() {
        return (Framebuffer) this.framebuffer;
    }

    // NOP BufferRenderer because there is no BufferRenderer in this version
    private static final BufferRenderer BUFFER_RENDERER = new BufferRenderer() {
        @Override public int getVertexArray() { return 0; }
        @Override public void setVertexArray(int vao) { }
        @Override public int getVertexBuffer() { return 0; }
        @Override public void setVertexBuffer(int vbo) { }
        @Override public int getElementBuffer() { return 0; }
        @Override public void setElementBuffer(int ibo) { }
    };
    @Override
    public BufferRenderer getBufferRenderer() {
        return BUFFER_RENDERER;
    }

    @Override
    public void shutdown() {
        ((Minecraft)((Object) this)).shutdown();
    }
}
