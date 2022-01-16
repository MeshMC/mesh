package dev.tigr.mesh.api.render;

import dev.tigr.mesh.util.render.GlState;

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

    IRenderState texture(boolean state);

    // TODO: LINE WIDTH - WILL HAVE TO REDO HOW LINES WORK ON FABRIC :(
}
