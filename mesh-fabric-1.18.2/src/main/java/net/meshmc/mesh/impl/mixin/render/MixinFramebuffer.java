package net.meshmc.mesh.impl.mixin.render;

import net.minecraft.client.gl.Framebuffer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Framebuffer.class)
public abstract class MixinFramebuffer implements net.meshmc.mesh.api.render.Framebuffer {
    @Shadow public int textureWidth;

    @Shadow public int textureHeight;

    @Shadow public int viewportWidth;

    @Shadow public int viewportHeight;

    @Shadow public int fbo;

    @Shadow public int texFilter;

    @Shadow @Final public boolean useDepthAttachment;

    @Shadow protected int depthAttachment;

    @Shadow protected int colorAttachment;

    @Shadow @Final private float[] clearColor;

    @Shadow public abstract void beginWrite(boolean setViewport);

    @Shadow public abstract void endWrite();

    @Shadow public abstract void beginRead();

    @Shadow public abstract void endRead();

    @Shadow public abstract void clear(boolean getError);

    @Shadow public abstract void resize(int width, int height, boolean getError);

    @Shadow public abstract void setTexFilter(int $$0);

    @Override
    public int getTextureWidth() {
        return this.textureWidth;
    }

    @Override
    public int getTextureHeight() {
        return this.textureHeight;
    }

    @Override
    public int getWidth() {
        return this.viewportWidth;
    }

    @Override
    public int getHeight() {
        return this.viewportHeight;
    }

    @Override
    public int getFBO() {
        return this.fbo;
    }

    @Override
    public int getTexture() {
        return this.colorAttachment;
    }

    @Override
    public boolean isUsingDepth() {
        return this.useDepthAttachment;
    }

    @Override
    public int getDepthAttachment() {
        return this.depthAttachment;
    }

    @Override
    public float[] getClearColor() {
        return this.clearColor;
    }

    @Override
    public int getFilter() {
        return this.texFilter;
    }

    @Override
    public void setFilter(int value) {
        this.setTexFilter(value);
    }

    @Override
    public void setClearColor(float r, float g, float b, float a) {
        clearColor[0] = r;
        clearColor[1] = g;
        clearColor[2] = b;
        clearColor[3] = a;
    }

    @Override
    public void bind(boolean updateViewport) {
        this.beginWrite(updateViewport);
    }

    @Override
    public void unbind() {
        this.endWrite();
    }

    @Override
    public void bindTexture() {
        this.beginRead();
    }

    @Override
    public void unbindTexture() {
        this.endRead();
    }

    @Override
    public void clear() {
        this.clear(false);
    }
}
