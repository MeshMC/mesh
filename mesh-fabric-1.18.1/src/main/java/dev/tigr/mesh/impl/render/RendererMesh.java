package dev.tigr.mesh.impl.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.util.render.LocationIdentifier;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Tigermouthbear 1/15/22
 */
public class RendererMesh extends Renderer {
    private final Map<String, AbstractTexture> textures = new HashMap<>();

    public RendererMesh() {
        super(new MatrixStackMesh(), new RenderStateMesh());
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

    @Override
    public BufferBuilder<?> begin(DrawMode drawMode, VertexFormat vertexFormat) {
        net.minecraft.client.render.BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        bufferBuilder.begin(convertDrawMode(drawMode), convertVertexFormat(vertexFormat));
        MatrixStack.Entry entry = ((MatrixStackMesh) getRenderStack()).getMatrixStack().peek();
        return new BufferBuilderMesh(bufferBuilder, entry.getPositionMatrix(), entry.getNormalMatrix());
    }

    @Override
    public void draw() {
        Tessellator.getInstance().draw();
    }

    private static net.minecraft.client.render.VertexFormat.DrawMode convertDrawMode(DrawMode drawMode) {
        if(drawMode == DrawMode.LINES) return net.minecraft.client.render.VertexFormat.DrawMode.DEBUG_LINES;
        if(drawMode == DrawMode.QUADS) return net.minecraft.client.render.VertexFormat.DrawMode.QUADS;
        return net.minecraft.client.render.VertexFormat.DrawMode.TRIANGLES;
    }

    private static net.minecraft.client.render.VertexFormat convertVertexFormat(VertexFormat vertexFormat) {
        if(vertexFormat == VertexFormat.POSITION_COLOR || vertexFormat == VertexFormat.LINES) {
            RenderSystem.setShader(GameRenderer::getPositionColorShader);
            RenderSystem.setShaderColor(1, 1, 1, 1);
            return VertexFormats.POSITION_COLOR;
        }
        if(vertexFormat == VertexFormat.POSITION_TEXTURE) {
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            return VertexFormats.POSITION_TEXTURE;
        }
        if(vertexFormat == VertexFormat.POSITION_TEXTURE_COLOR) {
            RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
            RenderSystem.setShaderColor(1, 1, 1, 1);
            return VertexFormats.POSITION_TEXTURE_COLOR;
        }
        if(vertexFormat == VertexFormat.POSITION_TEXTURE_COLOR_NORMAL) {
            RenderSystem.setShader(GameRenderer::getPositionTexColorNormalShader);
            RenderSystem.setShaderColor(1, 1, 1, 1);
            return VertexFormats.POSITION_TEXTURE_COLOR_NORMAL;
        }
        return VertexFormats.POSITION;
    }
}
