package dev.tigr.mesh.util.render;

import dev.tigr.mesh.api.math.Box;

/**
 * provides abstraction for rendering
 * @author Tigermouthbear 1/10/22
 */
public interface IRenderer {
    IRenderStack getRenderStack();

    void bindTexture(LocationIdentifier resourceLocation);

    void drawImage(double x, double y, double width, double height, LocationIdentifier identifier);

    void drawImage(double x, double y, double width, double height, LocationIdentifier identifier, Color color);

    void drawLine(double x1, double y1, double x2, double y2, int weight, Color color);

    void drawLine(double x1, double y1, double z1, double x2, double y2, double z2, int weight, Color color);

    void drawLineLoop(int weight, Color color, double... points);

    void drawRect(double x, double y, double width, double height, Color color);

    void startScissor(double x, double y, double width, double height);

    void stopScissor();

    void prepare3d();

    void end3d();

    void drawBox(Box<?> box, Color fillColor, Color lineColor, int... ignoredSides);
}
