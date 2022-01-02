package dev.tigr.mesh.impl;

import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.IMinecraft;
import dev.tigr.mesh.impl.client.MinecraftMesh;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

/**
 * Implementation of Mesh for Fabric 1.18.1
 *
 * @author Tigermouthbear 1/1/22
 */
public class MeshImpl extends Mesh implements ModInitializer {
    private static MinecraftMesh MINECRAFT;

    public MeshImpl() {
        super(LoaderType.FABRIC, "1.18.1");
    }

    @Override
    public void onInitialize() {
        MINECRAFT = new MinecraftMesh(MinecraftClient.getInstance());

        initializeMods();
    }

    @Override
    public IMinecraft getMinecraft() {
        return MINECRAFT;
    }
}
