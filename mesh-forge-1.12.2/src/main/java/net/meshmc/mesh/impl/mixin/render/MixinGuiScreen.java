package net.meshmc.mesh.impl.mixin.render;

import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.ScreenContext;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiScreen.class)
public class MixinGuiScreen implements ScreenContext {
    @Shadow public int width;

    @Shadow public int height;

    @Shadow public net.minecraft.client.Minecraft mc;

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public Minecraft getMinecraft() {
        return (Minecraft) this.mc;
    }

    @Override
    public void setMinecraft(Minecraft minecraft) {
        this.mc = (net.minecraft.client.Minecraft) minecraft;
    }
}
