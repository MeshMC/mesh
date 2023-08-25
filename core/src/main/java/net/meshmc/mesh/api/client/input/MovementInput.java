package net.meshmc.mesh.api.client.input;

public interface MovementInput {
    float getMovementSideways();
    void setMovementSideways(float value);

    float getMovementForward();
    void setMovementForward(float value);

    boolean getPressingForward();
    void setPressingForward(boolean value);

    boolean getPressingBack();
    void setPressingBack(boolean value);

    boolean getPressingLeft();
    void setPressingLeft(boolean value);

    boolean getPressingRight();
    void setPressingRight(boolean value);

    boolean getJumping();
    void setJumping(boolean value);

    boolean getSneaking();
    void setSneaking(boolean value);
}
