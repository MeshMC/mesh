package net.meshmc.mesh.impl.mixin.render;

import net.minecraft.client.shader.Framebuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Framebuffer.class)
public abstract class MixinFramebuffer implements net.meshmc.mesh.api.render.Framebuffer {
    @Shadow public int framebufferTextureWidth;

    @Shadow public int framebufferTextureHeight;

    @Shadow public int framebufferWidth;

    @Shadow public int framebufferHeight;

    @Shadow public int framebufferObject;

    @Shadow public int framebufferTexture;

    @Shadow public boolean useDepth;

    @Shadow public int depthBuffer;

    @Shadow public float[] framebufferColor;

    @Shadow public int framebufferFilter;

    @Shadow public abstract void setFramebufferFilter(int framebufferFilterIn);

    @Shadow public abstract void bindFramebuffer(boolean p_147610_1_);

    @Shadow public abstract void unbindFramebuffer();

    @Shadow public abstract void bindFramebufferTexture();

    @Shadow public abstract void unbindFramebufferTexture();

    @Shadow public abstract void framebufferRenderExt(int width, int height, boolean p_178038_3_);

    @Shadow public abstract void framebufferClear();

    @Override
    public int getTextureWidth() {
        return this.framebufferTextureWidth;
    }

    @Override
    public int getTextureHeight() {
        return this.framebufferTextureHeight;
    }

    @Override
    public int getWidth() {
        return this.framebufferWidth;
    }

    @Override
    public int getHeight() {
        return this.framebufferHeight;
    }

    @Override
    public int getFBO() {
        return this.framebufferObject;
    }

    @Override
    public int getTexture() {
        return this.framebufferTexture;
    }

    @Override
    public boolean isUsingDepth() {
        return this.useDepth;
    }

    @Override
    public int getDepthAttachment() {
        return this.depthBuffer;
    }

    @Override
    public int getFilter() {
        return this.framebufferFilter;
    }

    @Override
    public void setFilter(int value) {
        this.setFramebufferFilter(value);
    }

    @Override
    public float[] getClearColor() {
        return this.framebufferColor;
    }

    @Override
    public void setClearColor(float r, float g, float b, float a) {
        framebufferColor[0] = r;
        framebufferColor[1] = g;
        framebufferColor[2] = b;
        framebufferColor[3] = a;
    }

    @Override
    public void bind(boolean updateViewport) {
        this.bindFramebuffer(updateViewport);
    }

    @Override
    public void unbind() {
        this.unbindFramebuffer();
    }

    @Override
    public void bindTexture() {
        this.bindFramebufferTexture();
    }

    @Override
    public void unbindTexture() {
        this.unbindFramebufferTexture();
    }

    @Override
    public void draw(int width, int height, boolean disableBlend) {
        this.framebufferRenderExt(width, height, disableBlend);
    }

    @Override
    public void clear() {
        this.framebufferClear();
    }
}
