package net.meshmc.mesh.util.render;

import net.meshmc.mesh.Mesh;
import net.meshmc.mesh.api.render.BufferBuilder;
import net.meshmc.mesh.api.render.Renderer;

/**
 * A helper for drawing better lines in 2D space.
 *
 * This is necessary because 1.17+ line rendering using the line shader
 * is not accurate in 2D space - it draws lines which are slightly offset
 * and 1.17+ line rendering without the shader does not support line thickness.
 *
 * This is a workaround that'll work on all versions, although it is inefficient
 * as every line has 6 vertices and a lot of math to calculate them.
 *
 * @author Makrennel 03/21/2022
 */
public class LineHelper {
    public static void populateTriangleBuffer(BufferBuilder<?> bufferBuilder, Vertex[]... lines) {
        for(Vertex[] line: lines) {
            if(line.length != 6) continue;
            bufferBuilder.construct(line);
        }
    }

    public static void drawTriangulatedLines(Vertex[]... lines) {
        BufferBuilder<?> buffer = Mesh.getMesh().getRenderer().getBufferBuilder();
        buffer.begin(Renderer.DrawMode.TRIANGLES, Renderer.VertexFormat.POSITION_COLOR);

        for(Vertex[] line: lines) {
            if(line.length != 6) continue;
            buffer.construct(line);
        }

        buffer.draw();
    }

    public static Vertex[] getTriangulatedLine(Vertex vertex1, Vertex vertex2) {
        return getTriangulatedLine(vertex1, vertex2, 1);
    }

    public static Vertex[] getTriangulatedLine(Vertex vertex1, Vertex vertex2, double thickness) {
        return getTriangulatedLine(vertex1.x, vertex1.y, vertex2.x, vertex2.y, vertex1.getColor(), vertex2.getColor(), thickness);
    }

    public static Vertex[] getTriangulatedLine(double x1, double y1, double x2, double y2, Color color1, Color color2) {
        return getTriangulatedLine(x1, y1, x2, y2, color1, color2, 1);
    }


    public static Vertex[] getTriangulatedLine(double x1, double y1, double x2, double y2, Color color1, Color color2, double thickness) {
        thickness /= 2;
        double xA, yA, xB, yB;
        
        if(x1 > x2) {
            xA = x2; yA = y2;
            xB = x1; yB = y1;
        } else {
            xA = x1; yA = y1;
            xB = x2; yB = y2;
        }

        double
                xDiff = xB - xA,
                yDiff = yB - yA,
                dist = Math.sqrt(xDiff * xDiff + yDiff * yDiff),
                xDiff2 = xA + dist - xB,
                opp = Math.sqrt(xDiff2 * xDiff2 + yDiff * yDiff),
                bearing = Math.acos((dist * dist + dist * dist - opp * opp) / (2 * dist * dist)),
                qAngle = Math.atan(thickness / dist),
                qDist = Math.sqrt(dist * dist + thickness * thickness);

        int mod = yDiff < 0 ? -1 : 1;

        Vertex v1 = new Vertex(
                xA + thickness * Math.cos(bearing - (Math.PI / 2)),
                yA + thickness * Math.sin(bearing - (Math.PI / 2))
        ), v2 = new Vertex(
                xA + thickness * Math.cos(bearing + (Math.PI / 2)),
                yA + thickness * Math.sin(bearing + (Math.PI / 2))
        ), v3 = new Vertex(
                xA + qDist * Math.cos(bearing + qAngle),
                yA + (mod * (qDist * Math.sin(bearing + qAngle)))
        ), v4 = new Vertex(
                xA + qDist * Math.cos(bearing - qAngle),
                yA + (mod * (qDist * Math.sin(bearing - qAngle)))
        );

        v1.color(x1 > x2 ? color2 : color1);
        v2.color(x1 > x2 ? color2 : color1);
        v3.color(x1 > x2 ? color1 : color2);
        v4.color(x1 > x2 ? color1 : color2);

        if(mod == -1)
            return new Vertex[] {v2, v1, v3, v1, v4, v3};
        else
            return new Vertex[] {v1, v2, v3, v1, v3, v4};
    }
}
