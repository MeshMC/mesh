package dev.tigr.mesh.impl.client;

import dev.tigr.mesh.api.IMinecraft;
import dev.tigr.mesh.api.util.ISession;
import dev.tigr.mesh.impl.client.util.SessionMesh;
import net.minecraft.client.MinecraftClient;

/**
 * Mesh API interface for Minecraft's main class
 *
 * @author Tigermouthbear 1/1/22
 */
public class MinecraftMesh implements IMinecraft {
    private final MinecraftClient minecraft;
    private final SessionMesh session;

    public MinecraftMesh(MinecraftClient minecraft) {
        this.minecraft = minecraft;
        this.session = new SessionMesh(minecraft.getSession());
    }

    @Override
    public ISession getSession() {
        return session;
    }
}
