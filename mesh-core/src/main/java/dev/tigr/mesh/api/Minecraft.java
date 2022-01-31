package dev.tigr.mesh.api;

import dev.tigr.mesh.api.render.TextRenderer;
import dev.tigr.mesh.api.util.Profiler;
import dev.tigr.mesh.api.util.Session;
import dev.tigr.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import dev.tigr.mesh.impl.mixininterface.world.ClientWorld;

/**
 * Provides a mesh interface for the main minecraft class
 * @author Tigermouthbear 1/10/22
 */
public interface Minecraft<T> extends IMesh<T> {
    Profiler<?> getProfiler();

    TextRenderer<?> getTextRenderer();

    Session<?> getSession();
    void setSession(Session<?> session);

    ClientWorld getWorld();
    void setWorld(ClientWorld world);

    EntityClientPlayer getPlayer();
    void setPlayer(EntityClientPlayer player);
}
