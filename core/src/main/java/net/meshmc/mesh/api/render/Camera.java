package net.meshmc.mesh.api.render;

import net.meshmc.mesh.api.math.Vec3d;

/**
 * Provides camera information such as position and rotation
 * @author Tigermouthbear 3/24/22
 */
public interface Camera {
    Vec3d getPos();

    double getX();
    double getY();
    double getZ();

    float getPitch(); // playerViewX
    float getYaw(); // playerViewY
}
