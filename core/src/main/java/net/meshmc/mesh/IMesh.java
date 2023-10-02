package net.meshmc.mesh;

import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.Utilities;

public interface IMesh {
    Minecraft getMinecraft();

    Renderer getRenderer();

    Utilities getUtilities();
}
