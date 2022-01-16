package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.util.render.LocationIdentifier;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tigermouthbear 1/15/22
 */
public class RendererMesh extends Renderer {
    private final Map<String, DynamicTexture> textures = new HashMap<>();

    public RendererMesh() {
        super(new MatrixStackMesh(), new RenderStateMesh());
    }

    @Override
    public void bindTexture(LocationIdentifier locationIdentifier) {
        DynamicTexture texture = textures.get(locationIdentifier.getPath());
        if(texture == null) {
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(Objects.requireNonNull(RendererMesh.class.getResourceAsStream(locationIdentifier.getPath())));
            } catch(Exception e) {
                e.printStackTrace();
                return;
            }
            texture = new DynamicTexture(bufferedImage);
            textures.put(locationIdentifier.getPath(), texture);
        }

        GlStateManager.bindTexture(texture.getGlTextureId());
    }

    @Override
    public BufferBuilder<?> begin(DrawMode drawMode, VertexFormat vertexFormat) {
        net.minecraft.client.renderer.BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(convertDrawMode(drawMode), convertVertexFormat(vertexFormat));
        return new BufferBuilderMesh(bufferBuilder);
    }

    @Override
    public void draw() {
        GlStateManager.color(1, 1, 1, 1);
        Tessellator.getInstance().draw();
    }

    private static int convertDrawMode(DrawMode drawMode) {
        if(drawMode == DrawMode.LINES) return GL11.GL_LINES;
        if(drawMode == DrawMode.QUADS) return GL11.GL_QUADS;
        return GL11.GL_TRIANGLES;
    }

    private static net.minecraft.client.renderer.vertex.VertexFormat convertVertexFormat(VertexFormat vertexFormat) {
        if(vertexFormat == VertexFormat.POSITION_COLOR || vertexFormat == VertexFormat.LINES) return DefaultVertexFormats.POSITION_COLOR;
        if(vertexFormat == VertexFormat.POSITION_TEXTURE) return DefaultVertexFormats.POSITION_TEX;
        if(vertexFormat == VertexFormat.POSITION_TEXTURE_COLOR) return DefaultVertexFormats.POSITION_TEX_COLOR;
        if(vertexFormat == VertexFormat.POSITION_TEXTURE_COLOR_NORMAL) return DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;
        return DefaultVertexFormats.POSITION;
    }
}
