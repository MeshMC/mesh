package net.meshmc.mesh.api.render;

import net.meshmc.mesh.util.render.GlState;

/**
 * Provides an interface for manipulating opengl state
 * @author Tigermouthbear 1/15/22
 */
public interface IRenderState {
    IRenderState alpha(boolean state);

    IRenderState blend(boolean state);

    IRenderState blendFunc(GlState.SourceFactor src, GlState.DestFactor dst);

    IRenderState cull(boolean state);

    IRenderState depth(boolean state);

    IRenderState depthMask(boolean state);

    IRenderState lighting(boolean state);

    IRenderState lineSmooth(boolean state);

    IRenderState lineWeight(float weight);

    IRenderState scissorBox(int x, int y, int width, int height);

    IRenderState scissor(boolean state);

    IRenderState texture(boolean state);
}
