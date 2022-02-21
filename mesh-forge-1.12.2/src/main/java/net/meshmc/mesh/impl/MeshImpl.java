package net.meshmc.mesh.impl;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.impl.wrapper.render.RendererMesh;
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
    private static Minecraft MINECRAFT;
    private static RendererMesh RENDERER;

    public MeshImpl() {
        super(LoaderType.FORGE, "1.12.2");
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MINECRAFT = (Minecraft) net.minecraft.client.Minecraft.getMinecraft();
        RENDERER = new RendererMesh();

        Mesh.initialize();

        MinecraftForge.EVENT_BUS.register(new ForgeEvents());
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
