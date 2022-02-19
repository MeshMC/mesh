package net.meshmc.mesh.impl.mixininterface.client;

import net.meshmc.mesh.api.util.Profiler;
import net.meshmc.mesh.impl.mixininterface.entity.living.player.EntityClientPlayer;
import net.meshmc.mesh.impl.mixininterface.render.TextRenderer;
import net.meshmc.mesh.impl.mixininterface.world.ClientWorld;

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
}
