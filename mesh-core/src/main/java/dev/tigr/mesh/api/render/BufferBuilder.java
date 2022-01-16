package dev.tigr.mesh.api.render;

import dev.tigr.mesh.api.AbstractMesh;
import dev.tigr.mesh.api.math.Vec3d;
import dev.tigr.mesh.api.math.Vec3f;
import dev.tigr.mesh.util.render.Color;

/**
 * Provides a mesh interface for creating render buffers in minecraft
 * @author Tigermouthbear 1/15/22
 */
public abstract class BufferBuilder<T> extends AbstractMesh<T> {
    public BufferBuilder(T value) {
        super(value);
    }

    public abstract BufferBuilder<?> vertex(double x, double y, double z);

    public BufferBuilder<?> vertex(Vec3d<?> vec3d) {
        return vertex(vec3d.getX(), vec3d.getY(), vec3d.getZ());
    }

    public BufferBuilder<?> vertex(double x, double y) {
        return vertex(x, y, 0);
    }

    public abstract BufferBuilder<?> color(float r, float g, float b, float a);

    public BufferBuilder<?> color(Color color) {
        return color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public abstract BufferBuilder<?> texture(float u, float v);

    public abstract BufferBuilder<?> normal(float x, float y, float z);

    public BufferBuilder<?> normal(Vec3f<?> vec3f) {
        return normal(vec3f.getX(), vec3f.getY(), vec3f.getZ());
    }

    public abstract BufferBuilder<?> next();
}
