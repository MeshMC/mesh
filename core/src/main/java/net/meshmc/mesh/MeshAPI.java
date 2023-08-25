package net.meshmc.mesh;

import dev.tigr.simpleevents.EventManager;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.Utilities;
import net.meshmc.mesh.event.MeshEventManager;
import net.meshmc.mesh.loader.MeshLoader;
import net.meshmc.mesh.loader.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MeshAPI implements Mod.Initializer {
    private static final Logger LOGGER = LogManager.getLogger("Mesh API");
    private static final EventManager EVENT_MANAGER = new MeshEventManager();

    @Mod.Interface
    private static IMesh MESH;

    @Override
    public void init(Mod mod) {
        LOGGER.info("Mesh API loaded in {} {}!",
                MeshLoader.getInstance().getRuntime().name().toLowerCase(),
                MeshLoader.getInstance().getGameVersion());
        // TODO: HANDLE VERSION NOT LOADED
    }

    public static EventManager getEventManager() {
        return EVENT_MANAGER;
    }

    public static Minecraft getMinecraft() {
        return MESH.getMinecraft();
    }

    public static Renderer getRenderer() {
        return MESH.getRenderer();
    }

    public static Utilities getUtilities() {
        return MESH.getUtilities();
    }
}