package net.meshmc.mesh.impl.mixin.render;

import net.meshmc.mesh.api.client.Minecraft;
import net.meshmc.mesh.api.render.ScreenContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Screen.class)
public class MixinScreen implements ScreenContext {
    @Shadow public int width;

    @Shadow public int height;

    @Shadow @Nullable protected MinecraftClient client;

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
        return (Minecraft) this.client;
    }

    @Override
    public void setMinecraft(Minecraft minecraft) {
        this.client = (MinecraftClient) minecraft;
    }
}
