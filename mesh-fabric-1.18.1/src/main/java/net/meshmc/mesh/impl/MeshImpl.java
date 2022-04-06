package net.meshmc.mesh.impl;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.fabricmc.loader.impl.FabricLoaderImpl;
import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.Utilities;
import net.meshmc.mesh.impl.wrapper.render.RendererMesh;
import net.meshmc.mesh.impl.wrapper.util.UtilitiesMesh;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.nio.file.Path;

/**
 * Implementation of Mesh for Fabric 1.18.1
 *
 * @author Tigermouthbear 1/1/22
 */
public class MeshImpl extends Mesh implements ModInitializer, PreLaunchEntrypoint {
    private static Minecraft MINECRAFT;
    private static RendererMesh RENDERER;
    private static UtilitiesMesh UTILITIES;

    public MeshImpl() {
        super(LoaderType.FABRIC, "1.18.1");
    }

    @Override
    public void onPreLaunch() {
        Mesh.load();
    }

    @Override
    public void onInitialize() {
        MINECRAFT = (Minecraft) MinecraftClient.getInstance();
        RENDERER = new RendererMesh();
        UTILITIES = new UtilitiesMesh();

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

    @Override
    public Utilities getUtilities() {
        return UTILITIES;
    }

    @Override
    public File getRunDirectory() {
        return FabricLoaderImpl.INSTANCE.getGameDir().toFile();
    }
}
