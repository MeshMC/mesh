package net.meshmc.mesh.api.render;

/**
 * Provides an interface for manipulating the opengl matrix stack
 * @author Tigermouthbear 1/15/22
 */
public interface IMatrixStack {
    void push();

    void pop();

    void scale(double x, double y, double z);

    void translate(double x, double y, double z);

    void rotate(float angle, float x, float y, float z);

    default void translate(Camera camera) {
        translate(-camera.getX(), -camera.getY(), -camera.getZ());
    }
}
