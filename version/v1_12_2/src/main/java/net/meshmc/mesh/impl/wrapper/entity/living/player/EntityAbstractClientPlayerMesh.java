package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityAbstractClientPlayer;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.client.entity.AbstractClientPlayer;

public class EntityAbstractClientPlayerMesh<T extends AbstractClientPlayer> extends EntityPlayerMesh<T> implements EntityAbstractClientPlayer {
    public EntityAbstractClientPlayerMesh(T value) {
        super(value);
    }

    @Override
    public float getElytraPitch() {
        return getMeshValue().rotateElytraX;
    }

    @Override
    public void setElytraPitch(float value) {
        getMeshValue().rotateElytraX = value;
    }

    @Override
    public float getElytraYaw() {
        return getMeshValue().rotateElytraY;
    }

    @Override
    public void setElytraYaw(float value) {
        getMeshValue().rotateElytraY = value;
    }

    @Override
    public float getElytraRoll() {
        return getMeshValue().rotateElytraZ;
    }

    @Override
    public void setElytraRoll(float value) {
        getMeshValue().rotateElytraZ = value;
    }

    @Override
    public boolean canRenderCapeTexture() {
        return getMeshValue().hasPlayerInfo();
    }

    @Override
    public boolean hasSkinTexture() {
        return getMeshValue().hasSkin();
    }

    @Override
    public LocationIdentifier getSkinTexture() {
        return (LocationIdentifier) getMeshValue().getLocationSkin();
    }

    @Override
    public LocationIdentifier getCapeTexture() {
        return (LocationIdentifier) getMeshValue().getLocationCape();
    }

    @Override
    public boolean canRenderElytraTexture() {
        return getMeshValue().isPlayerInfoSet();
    }

    @Override
    public LocationIdentifier getElytraTexture() {
        return (LocationIdentifier) getMeshValue().getLocationElytra();
    }

    @Override
    public String getModel() {
        return getMeshValue().getSkinType();
    }

    @Override
    public float getFovMultiplier() {
        return getMeshValue().getFovModifier();
    }
}
