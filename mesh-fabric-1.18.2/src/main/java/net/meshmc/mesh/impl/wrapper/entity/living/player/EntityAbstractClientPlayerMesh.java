package net.meshmc.mesh.impl.wrapper.entity.living.player;

import net.meshmc.mesh.api.entity.living.player.EntityAbstractClientPlayer;
import net.meshmc.mesh.api.util.LocationIdentifier;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public class EntityAbstractClientPlayerMesh<T extends AbstractClientPlayerEntity> extends EntityPlayerMesh<T> implements EntityAbstractClientPlayer {
    public EntityAbstractClientPlayerMesh(T value) {
        super(value);
    }

    @Override
    public float getElytraPitch() {
        return getMeshValue().elytraPitch;
    }

    @Override
    public void setElytraPitch(float value) {
        getMeshValue().elytraPitch = value;
    }

    @Override
    public float getElytraYaw() {
        return getMeshValue().elytraYaw;
    }

    @Override
    public void setElytraYaw(float value) {
        getMeshValue().elytraYaw = value;
    }

    @Override
    public float getElytraRoll() {
        return getMeshValue().elytraRoll;
    }

    @Override
    public void setElytraRoll(float value) {
        getMeshValue().elytraRoll = value;
    }

    @Override
    public boolean canRenderCapeTexture() {
        return getMeshValue().canRenderCapeTexture();
    }

    @Override
    public boolean hasSkinTexture() {
        return getMeshValue().hasSkinTexture();
    }

    @Override
    public LocationIdentifier getSkinTexture() {
        return (LocationIdentifier) getMeshValue().getSkinTexture();
    }

    @Override
    public LocationIdentifier getCapeTexture() {
        return (LocationIdentifier) getMeshValue().getCapeTexture();
    }

    @Override
    public boolean canRenderElytraTexture() {
        return getMeshValue().canRenderElytraTexture();
    }

    @Override
    public LocationIdentifier getElytraTexture() {
        return (LocationIdentifier) getMeshValue().getElytraTexture();
    }

    @Override
    public String getModel() {
        return getMeshValue().getModel();
    }

    @Override
    public float getFovMultiplier() {
        return getMeshValue().getFovMultiplier();
    }
}
