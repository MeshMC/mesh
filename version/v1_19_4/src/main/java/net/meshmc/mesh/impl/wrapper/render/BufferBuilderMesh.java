package net.meshmc.mesh.impl.wrapper.render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.meshmc.mesh.MeshAPI;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.api.render.buffer.BufferBuilder;
import net.meshmc.mesh.impl.mixin.accessors.render.BufferBuilderAccessor;
import net.meshmc.mesh.util.render.Vertex;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigermouthbear & Makrennel 1/15/22
 * // TODO: Does this still work?
 */
public class BufferBuilderMesh extends BufferBuilder<net.minecraft.client.render.BufferBuilder> {
    public BufferBuilderMesh(net.minecraft.client.render.BufferBuilder value) {
        super(value);
    }

    @Override
    public void begin(Renderer.DrawMode drawMode, Renderer.VertexFormat vertexFormat) {
        VertexFormat format;
        switch(vertexFormat) {
            case LINES -> {
                if(drawMode == Renderer.DrawMode.LINES) {
                    RenderSystem.setShader(GameRenderer::getRenderTypeLinesProgram);
                    format = VertexFormats.LINES;
                } else {
                    RenderSystem.setShader(GameRenderer::getPositionColorProgram);
                    format = VertexFormats.POSITION_COLOR;
                }
            }
            case POSITION_TEXTURE -> {
                RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                format = VertexFormats.POSITION_TEXTURE;
            }
            case POSITION_TEXTURE_COLOR -> {
                RenderSystem.setShader(GameRenderer::getPositionColorTexProgram);
                format = VertexFormats.POSITION_COLOR_TEXTURE;
            }
            default -> {
                RenderSystem.setShader(GameRenderer::getPositionColorProgram);
                format = VertexFormats.POSITION_COLOR;
            }
        }

        VertexFormat.DrawMode mode;
        switch(drawMode) {
            case LINES -> {
                if(format == VertexFormats.LINES) mode = VertexFormat.DrawMode.LINES;
                else mode = VertexFormat.DrawMode.DEBUG_LINES;
            }
            case LINE_STRIP -> {
                //TODO: Find out if it's possible to normalize LINE_STRIP properly
                mode = VertexFormat.DrawMode.DEBUG_LINE_STRIP;
            }
            case TRIANGLES -> mode = VertexFormat.DrawMode.TRIANGLES;
            case TRIANGLE_STRIP -> mode = VertexFormat.DrawMode.TRIANGLE_STRIP;
            case TRIANGLE_FAN -> mode = VertexFormat.DrawMode.TRIANGLE_FAN;
            default -> mode = VertexFormat.DrawMode.QUADS;
        }

        getMeshValue().begin(mode, format);

    }

    @Override
    public void construct(Vertex... vertices) {
        VertexFormat format = ((BufferBuilderAccessor) getMeshValue()).getVertexFormat();
        VertexFormat.DrawMode mode = ((BufferBuilderAccessor) getMeshValue()).getDrawMode();
        if(format == VertexFormats.LINES && mode == VertexFormat.DrawMode.LINES) {
            List<Line> lines = new ArrayList<>();
            Vertex lastVertex = null;

            for(Vertex vertex: vertices) {
                if(lastVertex != null) {
                    lines.add(new Line(lastVertex, vertex));
                    lastVertex = null;
                }
                else lastVertex = vertex;
            }

            for(Line line: lines) {
                vertex(line.vertex1, line.normalVec);
                vertex(line.vertex2, line.normalVec);
            }
        }
        else for(Vertex vert: vertices) vertex(vert, null);
    }

    private void vertex(Vertex vert, Vector3f normalVec) {
        getMeshValue().vertex(getModel(), (float) vert.x, (float) vert.y, (float) vert.z);

        // 1.18: Color 1st, Texture 2nd
        if(vert.colorNotNull())
            getMeshValue().color(vert.r, vert.g, vert.b, vert.a);

        if(vert.textureNotNull())
            getMeshValue().texture(vert.u, vert.v);

        if(normalVec != null)
            getMeshValue().normal(getNormal(), normalVec.x, normalVec.y, normalVec.z);

        getMeshValue().next();
    }

    private class Line {
        Vertex
                vertex1,
                vertex2;
        public Vector3f normalVec;

        Line(Vertex vertex1, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;

            normalVec = getNormal(vertex1.x, vertex1.y, vertex1.z, vertex2.x, vertex2.y, vertex2.z);
        }
    }

    @Override
    public void draw() {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        BufferRenderer.draw(getMeshValue().end());
    }

    MatrixStackMesh getRenderStack() {
        return (MatrixStackMesh) MeshAPI.getRenderer().getRenderStack();
    }

    Matrix4f getModel() {
        return getRenderStack().getMatrixStack().peek().getPositionMatrix();
    }

    Matrix3f getNormal() {
        return getRenderStack().getMatrixStack().peek().getNormalMatrix();
    }

    Vector3f getNormal(double x1, double y1, double z1, double x2, double y2, double z2) {
        return getNormal((float) x1, (float) y1, (float) z1, (float) x2, (float) y2, (float) z2);
    }

    Vector3f getNormal(float x1, float y1, float z1, float x2, float y2, float z2) {
        Vector3f normal = new Vector3f(x2 - x1, y2 - y1, z2 - z1);
        normal.normalize();
        return normal;
    }
}
