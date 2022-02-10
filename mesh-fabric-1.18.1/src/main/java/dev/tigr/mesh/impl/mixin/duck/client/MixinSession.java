package dev.tigr.mesh.impl.mixin.duck.client;

import net.minecraft.client.util.Session;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Session.class)
public abstract class MixinSession implements dev.tigr.mesh.impl.mixininterface.client.Session {
    @Override @Shadow public abstract String getSessionId();
    @Shadow @Final private String uuid;
    @Shadow @Final private String username;
    @Shadow @Final private String accessToken;

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }
}
