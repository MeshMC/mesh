package dev.tigr.mesh.impl.render;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tigr.mesh.Mesh;
import dev.tigr.mesh.api.render.BufferBuilder;
import dev.tigr.mesh.api.render.Renderer;
import dev.tigr.mesh.impl.mixin.accessors.render.BufferBuilderAccessor;
import dev.tigr.mesh.util.render.Vertex;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tigermouthbear & Makrennel 1/15/22
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
                    RenderSystem.setShader(GameRenderer::getRenderTypeLinesShader);
                    format = VertexFormats.LINES;
                } else {
                    RenderSystem.setShader(GameRenderer::getPositionColorShader);
                    format = VertexFormats.POSITION_COLOR;
                }
            }
            case POSITION_TEXTURE -> {
                RenderSystem.setShader(GameRenderer::getPositionTexShader);
                format = VertexFormats.POSITION_TEXTURE;
            }
            case POSITION_TEXTURE_COLOR -> {
                RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
                format = VertexFormats.POSITION_COLOR_TEXTURE;
            }
            default -> {
                RenderSystem.setShader(GameRenderer::getPositionColorShader);
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

    private void vertex(Vertex vert, Vec3f normalVec) {
        getMeshValue().vertex(getModel(), (float) vert.x, (float) vert.y, (float) vert.z);

        // 1.18: Color 1st, Texture 2nd
        if(vert.colorNotNull())
            getMeshValue().color(vert.r, vert.g, vert.b, vert.a);

        if(vert.textureNotNull())
            getMeshValue().texture(vert.u, vert.v);

        if(normalVec != null)
            getMeshValue().normal(getNormal(), normalVec.getX(), normalVec.getY(), normalVec.getZ());

        getMeshValue().next();
    }

    private class Line {
        Vertex
                vertex1,
                vertex2;
        public Vec3f normalVec;

        Line(Vertex vertex1, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;

            normalVec = getNormal(vertex1.x, vertex1.y, vertex1.z, vertex2.x, vertex2.y, vertex2.z);
        }
    }

    @Override
    public void construct(double... values) {
        Float
                x = null, y = null, z = null,
                r = null, g = null, b = null, a = null,
                u = null, v = null;

        VertexFormat format = ((BufferBuilderAccessor) getMeshValue()).getVertexFormat();
        VertexFormat.DrawMode mode = ((BufferBuilderAccessor) getMeshValue()).getDrawMode();
        if(format == VertexFormats.POSITION_COLOR) {
            for(Double val : values) {
                if(x == null) x = val.floatValue();
                else if(y == null) y = val.floatValue();
                else if(z == null) z = val.floatValue();
                else if(r == null) r = val.floatValue();
                else if(g == null) g = val.floatValue();
                else if(b == null) b = val.floatValue();
                else {
                    a = val.floatValue();

                    getMeshValue().vertex(getModel(), x, y, z).color(r, g, b, a).next();
                    x = y = z = r = g = b = a = null;
                }
            }
        } else if(format == VertexFormats.LINES) {
            Float
                    x2 = null, y2 = null, z2 = null,
                    r2 = null, g2 = null, b2 = null, a2 = null;

            if(mode == VertexFormat.DrawMode.LINES) {
                for(Double val: values) {
                    if(x == null) x = val.floatValue();
                    else if(y == null) y = val.floatValue();
                    else if(z == null) z = val.floatValue();
                    else if(r == null) r = val.floatValue();
                    else if(g == null) g = val.floatValue();
                    else if(b == null) b = val.floatValue();
                    else if(a == null) a = val.floatValue();

                    else if(x2 == null) x2 = val.floatValue();
                    else if(y2 == null) y2 = val.floatValue();
                    else if(z2 == null) z2 = val.floatValue();
                    else if(r2 == null) r2 = val.floatValue();
                    else if(g2 == null) g2 = val.floatValue();
                    else if(b2 == null) b2 = val.floatValue();
                    else {
                        a2 = val.floatValue();

                        Vec3f normal = getNormal(x, y, z, x2, y2, z2);
                        getMeshValue().vertex(getModel(), x, y, z).color(r, g, b, a)
                                .normal(getNormal(), normal.getX(), normal.getY(), normal.getZ()).next();
                        getMeshValue().vertex(getModel(), x2, y2, z2).color(r2, g2, b2, a2)
                                .normal(getNormal(), normal.getX(), normal.getY(), normal.getZ()).next();

                        x=y=z=r=g=b=a=x2=y2=z2=r2=g2=b2=a2=null;
                    }
                }
            } else { //LINE_LOOP
                Vec3f normal;
                for(Double val: values) {
                    if(x == null) x = val.floatValue();
                    else if(y == null) y = val.floatValue();
                    else if(z == null) z = val.floatValue();
                    else if(r == null) r = val.floatValue();
                    else if(g == null) g = val.floatValue();
                    else if(b == null) b = val.floatValue();
                    else if(a == null) a = val.floatValue();

                    else if(x2 == null) x2 = val.floatValue();
                    else if(y2 == null) y2 = val.floatValue();
                    else if(z2 == null) z2 = val.floatValue();
                    else if(r2 == null) r2 = val.floatValue();
                    else if(g2 == null) g2 = val.floatValue();
                    else if(b2 == null) b2 = val.floatValue();
                    else {
                        a2 = val.floatValue();

                        normal = getNormal(x, y, z, x2, y2, z2);
                        getMeshValue().vertex(getModel(), x, y, z).color(r, g, b, a)
                                .normal(getNormal(), normal.getX(), normal.getY(), normal.getZ()).next();

                        x = x2; y = y2; z = z2; r = r2; g = g2; b = b2; a = a2;
                        x2=y2=z2=r2=g2=b2=a2=null;
                    }
                }

                // When done iterating through list the last vertex will still be undrawn
                if(x != null && y != null && z != null && r != null && g != null && b != null && a != null) {
                    normal = getNormal(x, y, z, x2, y2, z2);
                    getMeshValue().vertex(getModel(), x, y, z).color(r, g, b, a)
                            .normal(getNormal(), normal.getX(), normal.getY(), normal.getZ()).next();
                }
            }
        } else if(format == VertexFormats.POSITION_TEXTURE) {
            for(Double val : values) {
                if (x == null) x = val.floatValue();
                else if(y == null) y = val.floatValue();
                else if(z == null) z = val.floatValue();
                else if(u == null) u = val.floatValue();
                else {
                    v = val.floatValue();

                    getMeshValue().vertex(getModel(), x, y, z).texture(u, v).next();
                    x = y = z = u = v = null;
                }
            }
        } else if(format == VertexFormats.POSITION_COLOR_TEXTURE) {
            for(Double val : values) {
                if(x == null) x = val.floatValue();
                else if(y == null) y = val.floatValue();
                else if(z == null) z = val.floatValue();
                else if(r == null) r = val.floatValue();
                else if(g == null) g = val.floatValue();
                else if(b == null) b = val.floatValue();
                else if(a == null) a = val.floatValue();
                else if(u == null) u = val.floatValue();
                else {
                    v = val.floatValue();

                    getMeshValue().vertex(getModel(), x, y, z).color(r, g, b, a).texture(u, v).next();
                    x = y = z = r = g = b = a = u = v = null;
                }
            }
        }
    }

    @Override
    public void draw() {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        getMeshValue().end();
        BufferRenderer.draw(getMeshValue());
    }

    MatrixStackMesh getRenderStack() {
        return (MatrixStackMesh) Mesh.getMesh().getRenderer().getRenderStack();
    }

    Matrix4f getModel() {
        return getRenderStack().getMatrixStack().peek().getPositionMatrix();
    }

    Matrix3f getNormal() {
        return getRenderStack().getMatrixStack().peek().getNormalMatrix();
    }

    Vec3f getNormal(double x1, double y1, double z1, double x2, double y2, double z2) {
        return getNormal((float) x1, (float) y1, (float) z1, (float) x2, (float) y2, (float) z2);
    }

    Vec3f getNormal(float x1, float y1, float z1, float x2, float y2, float z2) {
        Vec3f normal = new Vec3f(x2 - x1, y2 - y1, z2 - z1);
        normal.normalize();
        return normal;
    }
}
