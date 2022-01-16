package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.api.render.BufferBuilder;

/**
 * @author Tigermouthbear 1/15/22
 */
public class BufferBuilderMesh extends BufferBuilder<net.minecraft.client.renderer.BufferBuilder> {
    public BufferBuilderMesh(net.minecraft.client.renderer.BufferBuilder value) {
        super(value);
    }

    @Override
    public BufferBuilder<?> vertex(double x, double y, double z) {
        getMeshValue().pos(x, y, z);
        return this;
    }

    @Override
    public BufferBuilder<?> color(float r, float g, float b, float a) {
        getMeshValue().color(r, g, b, a);
        return this;
    }

    @Override
    public BufferBuilder<?> texture(float u, float v) {
        getMeshValue().tex(u, v);
        return this;
    }

    @Override
    public BufferBuilder<?> normal(float x, float y, float z) {
        getMeshValue().normal(x, y, z);
        return this;
    }

    @Override
    public BufferBuilder<?> next() {
        getMeshValue().endVertex();
        return this;
    }
}
