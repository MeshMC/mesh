package dev.tigr.mesh.api.math;

import dev.tigr.mesh.api.util.math.IAxisAlignedBox;

public class AxisAlignedBox implements IAxisAlignedBox {
    private double minX, minY, minZ, maxX, maxY, maxZ;

    public AxisAlignedBox(double x1, double y1, double z1, double x2, double y2, double z2) {
        minX = Math.min(x1, x2);
        minY = Math.min(y1, y2);
        minZ = Math.min(z1, z2);
        maxX = Math.max(x1, x2);
        maxY = Math.max(y1, y2);
        maxZ = Math.max(z1, z2);
    }

    public AxisAlignedBox(IAxisAlignedBox axisAlignedBox) {
        this(axisAlignedBox.minX(), axisAlignedBox.minY(), axisAlignedBox.minZ(), axisAlignedBox.maxX(), axisAlignedBox.maxY(), axisAlignedBox.maxZ());
    }

    @Override
    public Object getObject() {
        return this;
    }

    @Override
    public boolean equalsObject(Object obj) {
        return this.equals(obj);
    }

    @Override
    public boolean isWrapper() {
        return false;
    }

    @Override
    public double minX() {
        return minX;
    }

    @Override
    public double minY() {
        return minY;
    }

    @Override
    public double minZ() {
        return minZ;
    }

    @Override
    public double maxX() {
        return maxX;
    }

    @Override
    public double maxY() {
        return maxY;
    }

    @Override
    public double maxZ() {
        return maxZ;
    }

    @Override
    public IAxisAlignedBox set(double x1, double y1, double z1, double x2, double y2, double z2) {
        minX = Math.min(x1, x2);
        minY = Math.min(y1, y2);
        minZ = Math.min(z1, z2);
        maxX = Math.max(x1, x2);
        maxY = Math.max(y1, y2);
        maxZ = Math.max(z1, z2);
        return this;
    }
}
