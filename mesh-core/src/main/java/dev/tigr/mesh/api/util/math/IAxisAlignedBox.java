package dev.tigr.mesh.api.util.math;

/**
 * Interface for minecraft's Box/AxisAlignedBB objects
 *
 * @author Makrennel 2022/01/09
 */
public interface IAxisAlignedBox {
    default boolean equals(IAxisAlignedBox axisAlignedBox) {
        return this.minX() == axisAlignedBox.minX()
                && this.minY() == axisAlignedBox.minY()
                && this.minZ() == axisAlignedBox.minZ()
                && this.maxX() == axisAlignedBox.maxX()
                && this.maxY() == axisAlignedBox.maxY()
                && this.maxZ() == axisAlignedBox.maxZ();
    }

    Object getObject();

    boolean equalsObject(Object obj);

    default boolean isWrapper() {
        return true;
    }

    double minX();
    double minY();
    double minZ();
    double maxX();
    double maxY();
    double maxZ();

    IAxisAlignedBox set(double x1, double y1, double z1, double x2, double y2, double z2);

    default IAxisAlignedBox set(IAxisAlignedBox axisAlignedBox) {
        return set(axisAlignedBox.minX(), axisAlignedBox.minY(), axisAlignedBox.minZ(), axisAlignedBox.maxX(), axisAlignedBox.maxY(), axisAlignedBox.maxZ());
    }
}
