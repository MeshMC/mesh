package dev.tigr.mesh.impl;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.impl.client.MinecraftMesh;
import dev.tigr.mesh.impl.util.CustomRenderer;
import dev.tigr.mesh.util.render.IRenderer;
import net.minecraft.client.Minecraft;
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
    private static CustomRenderer RENDERER;

    public MeshImpl() {
        super(LoaderType.FORGE, "1.12.2");
    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MINECRAFT = new MinecraftMesh(Minecraft.getMinecraft());
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
