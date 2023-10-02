package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.render.RenderState;
import net.meshmc.mesh.util.render.GlState;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * @author Tigermouthbear & Makrennel 1/15/22
 */
public class RenderStateMesh implements RenderState {
    @Override
    public RenderState alpha(boolean state) {
        if(state) GlStateManager.enableAlpha();
        else GlStateManager.disableAlpha();
        return this;
    }

    @Override
    public RenderState blend(boolean state) {
        if(state) GlStateManager.enableBlend();
        else GlStateManager.disableBlend();
        return this;
    }

    @Override
    public RenderState blendFunc(GlState.SourceFactor src, GlState.DestFactor dst) {
        GlStateManager.blendFunc(src.getFactor(), dst.getFactor());
        return this;
    }

    @Override
    public RenderState cull(boolean state) {
        if(state) GlStateManager.enableCull();
        else GlStateManager.disableCull();
        return this;
    }

    @Override
    public RenderState depth(boolean state) {
        if(state) GlStateManager.enableDepth();
        else GlStateManager.disableDepth();
        return this;
    }

    @Override
    public RenderState depthMask(boolean state) {
        GlStateManager.depthMask(state);
        return this;
    }

    @Override
    public RenderState lighting(boolean state) {
        if(state) GlStateManager.enableLighting();
        else GlStateManager.disableLighting();
        return this;
    }

    @Override
    public RenderState lineSmooth(boolean state) {
        if(state) GL11.glEnable(GL11.GL_LINE_SMOOTH);
        else GL11.glDisable(GL11.GL_LINE_SMOOTH);
        return this;
    }

    @Override
    public RenderState lineWeight(float weight) {
        return this;
    }

    @Override
    public RenderState scissorBox(int x, int y, int width, int height) {
        GL11.glScissor(x, y, width, height);
        return this;
    }

    @Override
    public RenderState scissor(boolean state) {
        if(state) GL11.glEnable(GL11.GL_SCISSOR_TEST);
        else GL11.glDisable(GL11.GL_SCISSOR_TEST);
        return this;
    }

    @Override
    public RenderState texture(boolean state) {
        if(state) GlStateManager.enableTexture2D();
        else GlStateManager.disableTexture2D();
        return this;
    }
}
