package net.meshmc.mesh.util.render;

/**
 * represents an asset/resource in the jar/archive
 * @author Tigermouthbear 1/10/22
 */
public class LocationIdentifier {
    private final String path;

    public LocationIdentifier(String modid, String path) {
        this.path = "/assets/" + modid + "/" + path;
    }

    public LocationIdentifier(String path) {
        this.path = "/assets/" + path;
    }

    public String getPath() {
        return path;
    }
}