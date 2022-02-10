package dev.tigr.mesh.impl.mixin.duck.client;

import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import dev.tigr.mesh.impl.mixininterface.render.TextRenderer;
import dev.tigr.mesh.impl.mixininterface.client.Session;
import dev.tigr.mesh.impl.mixininterface.world.ClientWorld;
import dev.tigr.mesh.impl.wrapper.util.ProfilerMesh;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public class MixinMinecraft implements dev.tigr.mesh.impl.mixininterface.client.Minecraft {
    @Shadow @Final public net.minecraft.profiler.Profiler profiler;
    @Shadow public FontRenderer fontRenderer;
    @Mutable @Shadow @Final private net.minecraft.util.Session session;
    @Shadow public WorldClient world;
    @Shadow public EntityPlayerSP player;

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
        return (ClientWorld) world;
    }

    @Override
    public void setWorld(ClientWorld world) {
        this.world = (WorldClient) world;
    }

    @Override
    public EntityClientPlayer getPlayer() {
        return (EntityClientPlayer) player;
    }

    @Override
    public void setPlayer(EntityClientPlayer player) {
        this.player = (EntityPlayerSP) player;
    }
}
