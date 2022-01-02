package dev.tigr.mesh.api.util;

import java.util.Optional;

public interface ISession {
    String getSessionId();

    String getUuid();

    String getUsername();

    String getAccessToken();

    // TODO: NOT SUPPORTED IN SOME VERSIONS
    //Optional<String> getClientId();

    // TODO: NOT SUPPORTED IN SOME VERSIONS
    //Optional<String> getXuid();

    // TODO: MAKE GAMEPROFILE MESH
    //GameProfile getProfile();

    // TODO: MAKE ACCOUNTTYPE MESH
    //Session.AccountType getAccountType();
}
