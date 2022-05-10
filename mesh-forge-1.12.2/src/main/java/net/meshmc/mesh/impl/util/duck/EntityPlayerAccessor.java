package net.meshmc.mesh.impl.util.duck;

public interface EntityPlayerAccessor {
    int getFlyToggleTimer();
    void setFlyToggleTimer(int value);

    int getSleepTimer();
    void setSleepTimer(int value);

    int getXPSeed();
    void setXPSeed(int value);

    float getSpeedInAir();
    void setSpeedInAir(float value);

    int getLastXPSound();
    void setLastXPSound(int value);
}
