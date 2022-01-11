package dev.tigr.mesh.util.render;

/**
 * provides abstraction for opengl matrix stack
 * @author Tigermouthbear 1/10/22
 */
public interface IRenderStack {
    void push();

    void pop();

    void scale(double x, double y, double z);

    void translate(double x, double y, double z);

    void rotate(float angle, float x, float y, float z);
}
