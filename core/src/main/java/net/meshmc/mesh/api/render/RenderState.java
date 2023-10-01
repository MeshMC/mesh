package net.meshmc.mesh.api.render;

import net.meshmc.mesh.util.render.GlState;

/**
 * Provides an interface for manipulating opengl state
 * @author Tigermouthbear 1/15/22
 */
public interface RenderState {
    RenderState alpha(boolean state);

    RenderState blend(boolean state);

    RenderState blendFunc(GlState.SourceFactor src, GlState.DestFactor dst);

    RenderState cull(boolean state);

    RenderState depth(boolean state);

    RenderState depthMask(boolean state);

    RenderState lighting(boolean state);

    RenderState lineSmooth(boolean state);

    RenderState lineWeight(float weight);

    RenderState scissorBox(int x, int y, int width, int height);

    RenderState scissor(boolean state);

//    RenderState texture(boolean state);
}
