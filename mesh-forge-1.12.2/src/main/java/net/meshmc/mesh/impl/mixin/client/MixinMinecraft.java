package net.meshmc.mesh.impl.mixin.client;

import net.meshmc.mesh.api.client.Session;
import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.render.TextRenderer;
import net.meshmc.mesh.api.util.Profiler;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.impl.wrapper.util.ProfilerMesh;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public class MixinMinecraft implements net.meshmc.mesh.api.client.Minecraft {
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
