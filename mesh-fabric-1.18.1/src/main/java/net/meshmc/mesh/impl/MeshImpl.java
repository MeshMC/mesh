package net.meshmc.mesh.impl;

import net.fabricmc.api.ModInitializer;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.impl.wrapper.render.RendererMesh;
import net.minecraft.client.MinecraftClient;

/**
 * Implementation of Mesh for Fabric 1.18.1
 *
 * @author Tigermouthbear 1/1/22
 */
public class MeshImpl extends Mesh implements ModInitializer {
    private static Minecraft MINECRAFT;
    private static RendererMesh RENDERER;

    public MeshImpl() {
        super(LoaderType.FABRIC, "1.18.1");
    }

    @Override
    public void onInitialize() {
        MINECRAFT = (Minecraft) MinecraftClient.getInstance();
        RENDERER = new RendererMesh();

        Mesh.initialize();
    }

    @Override
    public Minecraft getMinecraft() {
        return MINECRAFT;
    }

    @Override
    public Renderer getRenderer() {
        return RENDERER;
    }
}
