package dev.tigr.mesh.impl.mixin.duck.client;

import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Session.class)
public abstract class MixinSession implements dev.tigr.mesh.impl.mixininterface.client.Session {
    @Shadow public abstract String getSessionID();
    @Shadow @Final private String playerID;
    @Shadow @Final private String username;
    @Shadow @Final private String token;

    @Override
    public String getSessionId() {
        return getSessionID();
    }

    @Override
    public String getUuid() {
        return playerID;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getAccessToken() {
        return token;
    }
}
