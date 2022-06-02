package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.render.BufferBuilder;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.util.render.Vertex;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import org.lwjgl.opengl.GL11;

/**
 * @author Tigermouthbear & Makrennel 1/15/22
 */
public class BufferBuilderMesh extends BufferBuilder<net.minecraft.client.renderer.BufferBuilder> {
    public BufferBuilderMesh(net.minecraft.client.renderer.BufferBuilder value) {
        super(value);
    }

    final WorldVertexBufferUploader vboUploader = new WorldVertexBufferUploader();

    @Override
    public void begin(Renderer.DrawMode drawMode, Renderer.VertexFormat vertexFormat) {
        VertexFormat format;
        switch(vertexFormat) {
            case POSITION_TEXTURE:
                format = DefaultVertexFormats.POSITION_TEX;
                break;
            case POSITION_TEXTURE_COLOR:
                format = DefaultVertexFormats.POSITION_TEX_COLOR;
                break;
            default:
                format = DefaultVertexFormats.POSITION_COLOR;
        }

        int mode;
        switch(drawMode) {
            case LINES:
                mode = GL11.GL_LINES;
                break;
            case LINE_STRIP:
                mode = GL11.GL_LINE_STRIP;
                break;
            case TRIANGLES:
                mode = GL11.GL_TRIANGLES;
                break;
            case TRIANGLE_STRIP:
                mode = GL11.GL_TRIANGLE_STRIP;
                break;
            case TRIANGLE_FAN:
                mode = GL11.GL_TRIANGLE_FAN;
                break;
            default:
                mode = GL11.GL_QUADS;
        }

        getMeshValue().begin(mode, format);
    }

    @Override
    public void construct(Vertex... vertices) {
        for(Vertex vert: vertices) {
            getMeshValue().pos(vert.x, vert.y, vert.z);

            // 1.12: Texture 1st, Color 2nd
            if(vert.textureNotNull())
                getMeshValue().tex(vert.u, vert.v);

            if(vert.colorNotNull())
                getMeshValue().color(vert.r, vert.g, vert.b, vert.a);

            getMeshValue().endVertex();
        }
    }

    @Override
    public void draw() {
        GlStateManager.color(1,1,1,1);
        getMeshValue().finishDrawing();
        vboUploader.draw(getMeshValue());
    }
}
