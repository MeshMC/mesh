package net.meshmc.mesh.impl.wrapper.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.meshmc.mesh.api.render.IRenderState;
import net.meshmc.mesh.util.render.GlState;

/**
 * @author Tigermouthbear & Makrennel 1/15/22
 */
public class RenderStateMesh implements IRenderState {
    @Override
    public IRenderState alpha(boolean state) {
        // TODO: FIND OUT IF WE EVEN NEED THIS FOR FABRIC
        return this;
    }

    @Override
    public IRenderState blend(boolean state) {
        if(state) RenderSystem.enableBlend();
        else RenderSystem.disableBlend();
        return this;
    }

    @Override
    public IRenderState blendFunc(GlState.SourceFactor src, GlState.DestFactor dst) {
        RenderSystem.blendFunc(src.getFactor(), dst.getFactor());
        return this;
    }

    @Override
    public IRenderState cull(boolean state) {
        if(state) RenderSystem.enableCull();
        else RenderSystem.disableCull();
        return this;
    }

    @Override
    public IRenderState depth(boolean state) {
        if(state) RenderSystem.enableDepthTest();
        else RenderSystem.disableDepthTest();
        return this;
    }

    @Override
    public IRenderState depthMask(boolean state) {
        RenderSystem.depthMask(state);
        return this;
    }

    @Override
    public IRenderState lighting(boolean state) {
        // TODO: FIND OUT IF WE EVEN NEED THIS FOR FABRIC
        return this;
    }

    @Override
    public IRenderState lineSmooth(boolean state) {
        // TODO: FIND OUT IF WE EVEN NEED THIS FOR FABRIC
        return this;
    }

    @Override
    public IRenderState lineWeight(float weight) {
        RenderSystem.lineWidth(weight);
        return this;
    }

    @Override
    public IRenderState scissorBox(int x, int y, int width, int height) {
        GlStateManager._scissorBox(x, y, width, height);
        return this;
    }

    @Override
    public IRenderState scissor(boolean state) {
        if(state) GlStateManager._enableScissorTest();
        else GlStateManager._disableScissorTest();
        return this;
    }

    @Override
    public IRenderState texture(boolean state) {
        if(state) RenderSystem.enableTexture();
        else RenderSystem.disableTexture();
        return this;
    }
}
