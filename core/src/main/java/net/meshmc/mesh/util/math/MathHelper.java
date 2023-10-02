package net.meshmc.mesh.util.math;

public class MathHelper {
    public static float lerp(float delta, float start, float end) {
        return start + (end - start) * delta;
    }

    public static double lerp(double delta, double start, double end) {
        return start + (end - start) * delta;
    }
}
