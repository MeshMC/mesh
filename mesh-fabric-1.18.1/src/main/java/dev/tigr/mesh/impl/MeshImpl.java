package dev.tigr.mesh.impl;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.impl.render.RendererMesh;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

/**
 * Implementation of Mesh for Fabric 1.18.1
 *
 * @author Tigermouthbear 1/1/22
 */
public class MeshImpl extends Mesh implements ModInitializer {
    private static MinecraftMesh MINECRAFT;
    private static RendererMesh RENDERER;

    public MeshImpl() {
        super(LoaderType.FABRIC, "1.18.1");
    }

    @Override
    public void onInitialize() {
        MINECRAFT = new MinecraftMesh(MinecraftClient.getInstance());
        RENDERER = new RendererMesh();

        initializeMods();
    }

    @Override
    public MinecraftMesh getMinecraft() {
        return MINECRAFT;
    }

    @Override
    public Renderer getRenderer() {
        return RENDERER;
    }
}
