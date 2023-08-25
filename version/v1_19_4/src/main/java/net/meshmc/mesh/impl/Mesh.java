package net.meshmc.mesh.impl;

import net.meshmc.mesh.IMesh;
import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.Utilities;
import net.meshmc.mesh.impl.wrapper.render.RendererMesh;
import net.meshmc.mesh.impl.wrapper.util.UtilitiesMesh;
import net.meshmc.mesh.loader.Mod;
import net.minecraft.client.MinecraftClient;

@Mod.Interface
public class Mesh implements IMesh {
    @Override
    public Minecraft getMinecraft() {
        return (Minecraft) MinecraftClient.getInstance();
    }

    @Override
    public Renderer getRenderer() {
        return new RendererMesh();
    }

    @Override
    public Utilities getUtilities() {
        return new UtilitiesMesh();
    }
}
