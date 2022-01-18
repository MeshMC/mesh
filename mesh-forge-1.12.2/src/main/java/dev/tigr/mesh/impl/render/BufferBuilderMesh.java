package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.util.render.Vertex;
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
    public void construct(double... values) {
        Double
                x = null, y = null, z = null;
        Float
                r = null, g = null, b = null, a = null,
                u = null, v = null;

        VertexFormat format = getMeshValue().getVertexFormat();

        if(format == DefaultVertexFormats.POSITION_COLOR) {
            for(Double val : values) {
                if(x == null) x = val;
                else if(y == null) y = val;
                else if(z == null) z = val;
                else if(r == null) r = val.floatValue();
                else if(g == null) g = val.floatValue();
                else if(b == null) b = val.floatValue();
                else {
                    a = val.floatValue();

                    getMeshValue().pos(x, y, z).color(r, g, b, a).endVertex();
                    x = y = z = null; r = g = b = a = null;
                }
            }
        }
        else if(format == DefaultVertexFormats.POSITION_TEX) {
            for(Double val : values) {
                if(x == null) x = val;
                else if(y == null) y = val;
                else if(z == null) z = val;
                else if(u == null) u = val.floatValue();
                else {
                    v = val.floatValue();

                    getMeshValue().pos(x, y, z).tex(u, v).endVertex();
                    x = y = z = null; u = v = null;
                }
            }
        }
        else if(format == DefaultVertexFormats.POSITION_TEX_COLOR) {
            for(Double val : values) {
                if(x == null) x = val;
                else if(y == null) y = val;
                else if(z == null) z = val;
                else if(r == null) r = val.floatValue();
                else if(g == null) g = val.floatValue();
                else if(b == null) b = val.floatValue();
                else if(a == null) a = val.floatValue();
                else if(u == null) u = val.floatValue();
                else {
                    v = val.floatValue();

                    getMeshValue().pos(x, y, z).tex(u, v).color(r, g, b, a).endVertex();
                    x = y = z = null; r = g = b = a = u = v = null;
                }
            }
        }
    }

    @Override
    public void draw() {
        GlStateManager.color(1,1,1,1);
        getMeshValue().finishDrawing();
        vboUploader.draw(getMeshValue());
    }
}
