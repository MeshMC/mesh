package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.render.buffer.MatrixStack;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import java.nio.FloatBuffer;

/**
 * @author Tigermouthbear 1/15/22
 */
public class MatrixStackMesh implements MatrixStack {
    @Override
    public void push() {
        GlStateManager.pushMatrix();
    }

    @Override
    public void pop() {
        GlStateManager.popMatrix();
    }

    @Override
    public void scale(double x, double y, double z) {
        GlStateManager.scale(x, y, z);
    }

    @Override
    public void translate(double x, double y, double z) {
        GlStateManager.translate(x, y, z);
    }

    @Override
    public void rotate(float angle, float x, float y, float z) {
        GlStateManager.rotate(angle, x, y, z);
    }

    @Override
    public FloatBuffer getProjectionMatrix() {
        return getMatrix(GL11.GL_PROJECTION_MATRIX);
    }

    @Override
    public FloatBuffer getModelMatrix() {
        return getMatrix(GL11.GL_MODELVIEW_MATRIX);
    }

    private FloatBuffer getMatrix(int mode) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(mode, buffer);
        return buffer;
    }
}
