package net.meshmc.mesh.impl.wrapper.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.meshmc.mesh.api.render.Camera;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tigermouthbear 1/15/22
 */
public class RendererMesh extends Renderer {
    private final Map<String, AbstractTexture> textures = new HashMap<>();
    private final Camera camera = new CameraMesh();

    public RendererMesh() {
        super(new MatrixStackMesh(), new RenderStateMesh(), new BufferBuilderMesh(Tessellator.getInstance().getBuffer()));
    }

    @Override
    public void bindTexture(LocationIdentifier locationIdentifier) {
        AbstractTexture texture = textures.get(locationIdentifier.getFullPath());
        if(texture == null) {
            try {
                texture = new NativeImageBackedTexture(NativeImage.read(Objects.requireNonNull(RendererMesh.class.getResourceAsStream(locationIdentifier.getFullPath()))));
                textures.put(locationIdentifier.getFullPath(), texture);
            } catch(Exception e) {
                e.printStackTrace();
                return;
            }
        }

        RenderSystem.setShaderTexture(0, texture.getGlId());
    }

    @Override
    public Camera getCamera() {
        return camera;
    }
}
