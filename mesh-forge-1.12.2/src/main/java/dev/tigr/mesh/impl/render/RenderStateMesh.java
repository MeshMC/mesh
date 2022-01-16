package dev.tigr.mesh.impl.render;

import dev.tigr.mesh.api.render.IRenderState;
import dev.tigr.mesh.util.render.GlState;
import net.minecraft.client.renderer.GlStateManager;

/**
 * @author Tigermouthbear 1/15/22
 */
public class RenderStateMesh implements IRenderState {
    @Override
    public IRenderState alpha(boolean state) {
        if(state) GlStateManager.enableAlpha();
        else GlStateManager.disableAlpha();
        return this;
    }

    @Override
    public IRenderState blend(boolean state) {
        if(state) GlStateManager.enableBlend();
        else GlStateManager.disableBlend();
        return this;
    }

    @Override
    public IRenderState blendFunc(GlState.SourceFactor src, GlState.DestFactor dst) {
        GlStateManager.blendFunc(src.getFactor(), dst.getFactor());
        return this;
    }

    @Override
    public IRenderState cull(boolean state) {
        if(state) GlStateManager.enableCull();
        else GlStateManager.disableCull();
        return this;
    }

    @Override
    public IRenderState depth(boolean state) {
        if(state) GlStateManager.enableDepth();
        else GlStateManager.disableDepth();
        return this;
    }

    @Override
    public IRenderState depthMask(boolean state) {
        GlStateManager.depthMask(state);
        return this;
    }

    @Override
    public IRenderState texture(boolean state) {
        if(state) GlStateManager.enableTexture2D();
        else GlStateManager.disableTexture2D();
        return this;
    }
}
