package net.meshmc.mesh.util.render;

import net.meshmc.mesh.api.math.Vec3d;

/**
 * @author Makrennel 2022/01/18
 */
public class Vertex {
    public double x, y, z;
    public Float
            r = null,
            g = null,
            b = null,
            a = null,
            u = null,
            v = null;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vertex(double x, double y) {
        this(x,y,0);
    }

    public Vertex color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        return this;
    }

    public Vertex color(Color color) {
        return color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public Vertex texture(float u, float v) {
        this.u = u;
        this.v = v;
        return this;
    }

    public Vertex(double x, double y, double z, float r, float g, float b, float a) {
        this(x, y, z);
        color(r, g, b, a);
    }

    public Vertex(double x, double y, float r, float g, float b, float a) {
        this(x, y);
        color(r, g, b, a);
    }

    public Vertex(double x, double y, double z, Color color) {
        this(x, y, z);
        color(color);
    }

    public Vertex(double x, double y, Color color) {
        this(x, y);
        color(color);
    }

    public Vertex(Vec3d pos, float r, float g, float b, float a) {
        this(pos.getX(), pos.getY(), pos.getZ());
        color(r, g, b, a);
    }

    public Vertex(Vec3d pos, Color color) {
        this(pos.getX(), pos.getY(), pos.getZ());
        color(color);
    }

    public boolean colorNotNull() {
        return r != null && g != null && b != null && a != null;
    }

    public boolean textureNotNull() {
        return u != null && v != null;
    }

    public Vec3d getPos() {
        return Vec3d.create(x, y, z);
    }

    public Color getColor() {
        return new Color(r, g, b, a);
    }
}
