package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.api.render.BufferBuilder;
import net.minecraft.util.math.Matrix3f;
import net.minecraft.util.math.Matrix4f;

/**
 * @author Tigermouthbear 1/15/22
 */
public class BufferBuilderMesh extends BufferBuilder<net.minecraft.client.render.BufferBuilder> {
    private final Matrix4f model;
    private final Matrix3f normal;

    public BufferBuilderMesh(net.minecraft.client.render.BufferBuilder value, Matrix4f model, Matrix3f normal) {
        super(value);

        this.model = model;
        this.normal = normal;
    }

    @Override
    public BufferBuilder<?> vertex(double x, double y, double z) {
        getMeshValue().vertex(model, (float) x, (float) y, (float) z);
        return this;
    }

    @Override
    public BufferBuilder<?> color(float r, float g, float b, float a) {
        getMeshValue().color(r, g, b, a);
        return this;
    }

    @Override
    public BufferBuilder<?> texture(float u, float v) {
        getMeshValue().texture(u, v);
        return this;
    }

    @Override
    public BufferBuilder<?> normal(float x, float y, float z) {
        getMeshValue().normal(normal, x, y, z);
        return this;
    }

    @Override
    public BufferBuilder<?> next() {
        getMeshValue().next();
        return this;
    }
}
