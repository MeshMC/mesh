package dev.tigr.mesh.impl.client.util.math;

import dev.tigr.mesh.api.util.math.IAxisAlignedBox;
import dev.tigr.mesh.impl.mixininterface.IAxisAlignedBB;
import net.minecraft.util.math.AxisAlignedBB;

/**
 * Mesh API interface for wrapping minecraft's AxisAlignedBB class
 *
 * @author Makrennel 2022/01/09
 */
public class AxisAlignedBBMesh implements IAxisAlignedBox {
    AxisAlignedBB box;

    private AxisAlignedBBMesh(AxisAlignedBB box) {
        this.box = box;
    }

    public static AxisAlignedBBMesh wrap(AxisAlignedBB box) {
        return new AxisAlignedBBMesh(box);
    }

    public AxisAlignedBB get() {
        return box;
    }

    @Override
    public Object getObject() {
        return box;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return box.equals(obj);
    }

    @Override
    public double minX() {
        return box.minX;
    }

    @Override
    public double minY() {
        return box.minY;
    }

    @Override
    public double minZ() {
        return box.minZ;
    }

    @Override
    public double maxX() {
        return box.maxX;
    }

    @Override
    public double maxY() {
        return box.maxY;
    }

    @Override
    public double maxZ() {
        return box.maxZ;
    }

    @Override
    public IAxisAlignedBox set(double x1, double y1, double z1, double x2, double y2, double z2) {
        ((IAxisAlignedBB) box).setMinX(Math.min(x1, x2));
        ((IAxisAlignedBB) box).setMinY(Math.min(y1, y2));
        ((IAxisAlignedBB) box).setMinZ(Math.min(z1, z2));
        ((IAxisAlignedBB) box).setMaxX(Math.max(x1, x2));
        ((IAxisAlignedBB) box).setMaxY(Math.max(y1, y2));
        ((IAxisAlignedBB) box).setMaxZ(Math.max(z1, z2));
        return this;
    }
}
