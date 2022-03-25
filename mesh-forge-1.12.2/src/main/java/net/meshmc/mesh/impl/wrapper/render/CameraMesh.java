package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.render.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;

public class CameraMesh implements Camera {
    private final RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

    @Override
    public Vec3d getPos() {
        return Vec3d.create(renderManager.viewerPosX, renderManager.viewerPosY, renderManager.viewerPosZ);
    }

    @Override
    public double getX() {
        return renderManager.viewerPosX;
    }

    @Override
    public double getY() {
        return renderManager.viewerPosY;
    }

    @Override
    public double getZ() {
        return renderManager.viewerPosZ;
    }

    @Override
    public float getPitch() {
        return renderManager.playerViewX;
    }

    @Override
    public float getYaw() {
        return renderManager.playerViewY;
    }
}
