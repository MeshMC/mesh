package net.meshmc.mesh.impl.wrapper.render;

import net.meshmc.mesh.api.math.Vec3d;
import net.meshmc.mesh.api.render.Camera;
import net.minecraft.client.MinecraftClient;

/**
 * @author Tigermouthbear 3/24/22
 */
public class CameraMesh implements Camera {
    @Override
    public Vec3d getPos() {
        return (Vec3d) MinecraftClient.getInstance().gameRenderer.getCamera().getPos();
    }

    @Override
    public double getX() {
        return MinecraftClient.getInstance().gameRenderer.getCamera().getPos().x;
    }

    @Override
    public double getY() {
        return MinecraftClient.getInstance().gameRenderer.getCamera().getPos().y;
    }

    @Override
    public double getZ() {
        return MinecraftClient.getInstance().gameRenderer.getCamera().getPos().z;
    }

    @Override
    public float getPitch() {
        return MinecraftClient.getInstance().gameRenderer.getCamera().getPitch();
    }

    @Override
    public float getYaw() {
        return MinecraftClient.getInstance().gameRenderer.getCamera().getYaw();
    }
}
