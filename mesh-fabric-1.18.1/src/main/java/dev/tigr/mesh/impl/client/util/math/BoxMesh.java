package dev.tigr.mesh.impl.client.util.math;

import dev.tigr.mesh.api.util.math.IAxisAlignedBox;
import dev.tigr.mesh.impl.mixin.accessors.BoxAccessor;
import net.minecraft.util.math.Box;

/**
 * Mesh API interface for wrapping minecraft's Box class
 *
 * @author Makrennel 2022/01/09
 */
public class BoxMesh implements IAxisAlignedBox {
    Box box;

    private BoxMesh(Box box) {
        this.box = box;
    }

    public static BoxMesh wrap(Box box) {
        return new BoxMesh(box);
    }

    public static BoxMesh fromMeshStructure(IAxisAlignedBox axisAlignedBox) {
        return wrap(new Box(axisAlignedBox.minX(), axisAlignedBox.minY(), axisAlignedBox.minZ(), axisAlignedBox.maxX(), axisAlignedBox.maxY(), axisAlignedBox.maxZ()));
    }

    public Box get() {
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
        ((BoxAccessor) box).setMinX(Math.min(x1, x2));
        ((BoxAccessor) box).setMinY(Math.min(y1, y2));
        ((BoxAccessor) box).setMinZ(Math.min(z1, z2));
        ((BoxAccessor) box).setMaxX(Math.max(x1, x2));
        ((BoxAccessor) box).setMaxY(Math.max(y1, y2));
        ((BoxAccessor) box).setMaxZ(Math.max(z1, z2));
        return this;
    }
}
