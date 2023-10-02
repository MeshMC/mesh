package net.meshmc.mesh.api.render.buffer;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.AbstractMesh;
import net.meshmc.mesh.api.render.Renderer;
import net.meshmc.mesh.util.render.Vertex;

/**
 * Provides a mesh interface for creating render buffers in minecraft
 * @author Tigermouthbear & Makrennel 1/15/22
 */
public abstract class BufferBuilder<T> extends AbstractMesh<T> {
    public BufferBuilder(T value) {
        super(value);
    }

    public static BufferBuilder<?> create(int initialCapacity) {
        return MeshStatics.createBufferBuilder(initialCapacity);
    }

    public abstract void begin(Renderer.DrawMode drawMode, Renderer.VertexFormat vertexFormat);

    public abstract void construct(Vertex... vertices);

    public abstract void draw();
}
