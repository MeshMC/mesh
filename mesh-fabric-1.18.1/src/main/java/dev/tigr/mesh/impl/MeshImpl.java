package dev.tigr.mesh.impl;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.impl.client.MinecraftMesh;
import dev.tigr.mesh.impl.util.CustomRenderer;
import dev.tigr.mesh.util.render.IRenderer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

/**
 * Implementation of Mesh for Fabric 1.18.1
 *
 * @author Tigermouthbear 1/1/22
 */
public class MeshImpl extends Mesh implements ModInitializer {
    private static MinecraftMesh MINECRAFT;
    private static CustomRenderer RENDERER;

    public MeshImpl() {
        super(LoaderType.FABRIC, "1.18.1");
    }

    @Override
    public void onInitialize() {
        MINECRAFT = new MinecraftMesh(MinecraftClient.getInstance());
        RENDERER = new CustomRenderer();

        initializeMods();
    }

    @Override
    public MinecraftMesh getMinecraft() {
        return MINECRAFT;
    }

    @Override
    public IRenderer getRenderer() {
        return RENDERER;
    }
}
