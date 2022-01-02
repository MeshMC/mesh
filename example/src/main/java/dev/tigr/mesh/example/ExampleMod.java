package dev.tigr.mesh.example;

import dev.tigr.mesh.Mesh;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mesh.Mod(name = "Example Mod", modid = "examplemod", version = "1.0", description = "An example mod using the Mesh platform")
public class ExampleMod {
    private static final Logger LOGGER = LogManager.getLogger("Example Mod");
    public static final Mesh MESH = Mesh.getMesh();

    public void init() {
        LOGGER.info("Example Mod loaded in {} {}!",
                MESH.getLoaderType().name().toLowerCase(), MESH.getLoaderVersion());

        // woah, platform independent code!!!
        LOGGER.info("Hello {}!", MESH.getMinecraft().getSession().getUsername());
    }
}
