package net.meshmc.mesh.api.client;

import net.meshmc.mesh.api.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.api.render.Framebuffer;
import net.meshmc.mesh.api.render.TextRenderer;
import net.meshmc.mesh.api.util.Profiler;
import net.meshmc.mesh.api.world.ClientWorld;
import net.meshmc.mesh.util.render.Resolution;
import net.meshmc.mesh.util.render.Screen;

/**
 * Provides a mesh interface for the main minecraft class
 * @author Tigermouthbear 1/10/22
 */
public interface Minecraft {
    Profiler<?> getProfiler();

    TextRenderer getTextRenderer();

    Session getSession();
    void setSession(Session session);

    ClientWorld getWorld();
    void setWorld(ClientWorld world);

    EntityClientPlayer getPlayer();
    void setPlayer(EntityClientPlayer player);

    void openScreen(Screen screen);
    void closeScreen();

    Resolution getResolution();

    Framebuffer getFramebuffer();
}
