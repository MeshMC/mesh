package dev.tigr.mesh.impl.wrapper.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.util.render.LocationIdentifier;
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

    public RendererMesh() {
        super(new MatrixStackMesh(), new RenderStateMesh(), new BufferBuilderMesh(Tessellator.getInstance().getBuffer()));
    }

    @Override
    public void bindTexture(LocationIdentifier locationIdentifier) {
        AbstractTexture texture = textures.get(locationIdentifier.getPath());
        if(texture == null) {
            try {
                texture = new NativeImageBackedTexture(NativeImage.read(Objects.requireNonNull(RendererMesh.class.getResourceAsStream(locationIdentifier.getPath()))));
                textures.put(locationIdentifier.getPath(), texture);
            } catch(Exception e) {
                e.printStackTrace();
                return;
            }
        }

        RenderSystem.setShaderTexture(0, texture.getGlId());
    }
}
