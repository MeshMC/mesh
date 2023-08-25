package net.meshmc.mesh.impl.util.duck;

public interface NetworkConnectionDuck {
    int getPacketsReceivedCounter();
    void setPacketsReceivedCounter(int value);

    int getPacketsSentCounter();
    void setPacketsSentCounter(int value);

    float getAveragePacketsReceived();
    float getAveragePacketsSent();
}
