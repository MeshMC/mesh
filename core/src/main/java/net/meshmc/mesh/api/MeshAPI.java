package net.meshmc.mesh.api;

import net.meshmc.mesh.loader.MeshLoader;
import net.meshmc.mesh.loader.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MeshAPI implements Mod.Initializer {
    private static final Logger LOGGER = LogManager.getLogger("Mesh API");

    @Mod.Interface
    private static IMinecraft minecraft;

    @Override
    public void init(Mod mod) {
        LOGGER.info("Mesh API loaded in {} {}!",
                MeshLoader.getInstance().getRuntime().name().toLowerCase(),
                MeshLoader.getInstance().getGameVersion());
        // TODO: HANDLE VERSION NOT LOADED
    }

    public static IMinecraft getMinecraft() {
        return minecraft;
    }
}