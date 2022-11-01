package net.meshmc.mesh.api.entity.living.player;

import net.meshmc.mesh.MeshStatics;
import net.meshmc.mesh.api.util.LocationIdentifier;

public interface EntityAbstractClientPlayer extends EntityPlayer {
    // TODO: PlayerListEntry

    float getElytraPitch();
    void setElytraPitch(float value);

    float getElytraYaw();
    void setElytraYaw(float value);

    float getElytraRoll();
    void setElytraRoll(float value);

    boolean canRenderCapeTexture();

    // TODO: PlayerInfo

    boolean hasSkinTexture();

    LocationIdentifier getSkinTexture();

    LocationIdentifier getCapeTexture();

    boolean canRenderElytraTexture(); // Why are there two methods which return the exact same thing??

    LocationIdentifier getElytraTexture();

    // TODO: getDownloadImageSkin 1.12 & loadSkin 1.18 - they do the same thing but one returns?

    static LocationIdentifier getSkinId(String playerName) {
        return MeshStatics.EntityAbstractClientPlayer_getSkinId(playerName);
    }

    String getModel();

    float getFovMultiplier();
}
