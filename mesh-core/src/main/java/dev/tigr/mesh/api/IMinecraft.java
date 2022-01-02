package dev.tigr.mesh.api;

import dev.tigr.mesh.api.util.IProfiler;
import dev.tigr.mesh.api.util.ISession;

/**
 * The main interface of minecraft, holds the main logic of the game
 * and other important functions.
 *
 * @author Tigermouthbear 1/1/22
 */
public interface IMinecraft {
    IProfiler getProfiler();

    ISession getSession();
}
