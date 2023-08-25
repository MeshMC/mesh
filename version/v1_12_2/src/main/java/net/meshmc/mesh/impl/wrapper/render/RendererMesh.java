package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.render.Camera;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tigermouthbear 1/15/22
 */
public class RendererMesh extends Renderer {
    private final Map<String, DynamicTexture> textures = new HashMap<>();
    private final Camera camera = new CameraMesh();

    public RendererMesh() {
        super(new MatrixStackMesh(), new RenderStateMesh(), new BufferBuilderMesh(Tessellator.getInstance().getBuffer()));
    }

    @Override
    public void bindTexture(LocationIdentifier locationIdentifier) {
        DynamicTexture texture = textures.get(locationIdentifier.getFullPath());
        if(texture == null) {
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(Objects.requireNonNull(RendererMesh.class.getResourceAsStream(locationIdentifier.getFullPath())));
            } catch(Exception e) {
                e.printStackTrace();
                return;
            }
            texture = new DynamicTexture(bufferedImage);
            textures.put(locationIdentifier.getFullPath(), texture);
        }

        GlStateManager.bindTexture(texture.getGlTextureId());
    }

    @Override
    public Camera getCamera() {
        return camera;
    }
}
