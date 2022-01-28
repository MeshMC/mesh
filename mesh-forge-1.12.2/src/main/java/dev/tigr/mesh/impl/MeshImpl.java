package dev.tigr.mesh.impl;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.impl.render.RendererMesh;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Implementation of Mesh for Forge 1.12.2
 *
 * @author Tigermouthbear 1/1/22
 */
@Mod(name = "Mesh", modid = "mesh")
public class MeshImpl extends Mesh {
    private static MinecraftMesh MINECRAFT;
    private static RendererMesh RENDERER;

    public MeshImpl() {
        super(LoaderType.FORGE, "1.12.2");
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MINECRAFT = new MinecraftMesh(Minecraft.getMinecraft());
        RENDERER = new RendererMesh();

        Mesh.initialize();

        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
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
