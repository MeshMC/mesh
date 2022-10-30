package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketMovePlayer;
import net.meshmc.mesh.impl.mixin.accessors.packet.CPacketPlayerAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.play.client.CPacketPlayer;

public abstract class CPacketMovePlayerMesh<T extends CPacketPlayer> extends PacketMesh.Client<T> implements CPacketMovePlayer {
    public CPacketMovePlayerMesh(T value) {
        super(value);
    }

    public static class OnGround<T extends CPacketPlayer> extends CPacketMovePlayerMesh<T> implements CPacketMovePlayer.OnGround {
        public OnGround(T value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerOnGround;
        }

        @Override
        public boolean isOnGround() {
            return ((CPacketPlayerAccessor) getMeshValue()).isOnGround();
        }

        @Override
        public void setOnGround(boolean value) {
            ((CPacketPlayerAccessor) getMeshValue()).setOnGround(value);
        }
    }

    public static class Position extends OnGround<CPacketPlayer.Position> implements CPacketMovePlayer.Position {
        public Position(CPacketPlayer.Position value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerPosition;
        }

        @Override
        public double getX() {
            return ((CPacketPlayerAccessor) getMeshValue()).getX();
        }

        @Override
        public double getY() {
            return ((CPacketPlayerAccessor) getMeshValue()).getY();
        }

        @Override
        public double getZ() {
            return ((CPacketPlayerAccessor) getMeshValue()).getZ();
        }

        @Override
        public void setX(double value) {
            ((CPacketPlayerAccessor) getMeshValue()).setX(value);
        }

        @Override
        public void setY(double value) {
            ((CPacketPlayerAccessor) getMeshValue()).setY(value);
        }

        @Override
        public void setZ(double value) {
            ((CPacketPlayerAccessor) getMeshValue()).setZ(value);
        }
    }

    public static class Rotation extends OnGround<CPacketPlayer.Rotation> implements CPacketMovePlayer.Rotation {
        public Rotation(CPacketPlayer.Rotation value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerRotation;
        }

        @Override
        public float getYaw() {
            return ((CPacketPlayerAccessor) getMeshValue()).getYaw();
        }

        @Override
        public float getPitch() {
            return ((CPacketPlayerAccessor) getMeshValue()).getPitch();
        }

        @Override
        public void setYaw(float value) {
            ((CPacketPlayerAccessor) getMeshValue()).setYaw(value);
        }

        @Override
        public void setPitch(float value) {
            ((CPacketPlayerAccessor) getMeshValue()).setPitch(value);
        }
    }

    public static class PositionRotation extends OnGround<CPacketPlayer.PositionRotation> implements CPacketMovePlayer.PositionRotation {
        public PositionRotation(CPacketPlayer.PositionRotation value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerPositionRotation;
        }

        @Override
        public double getX() {
            return ((CPacketPlayerAccessor) getMeshValue()).getX();
        }

        @Override
        public double getY() {
            return ((CPacketPlayerAccessor) getMeshValue()).getY();
        }

        @Override
        public double getZ() {
            return ((CPacketPlayerAccessor) getMeshValue()).getZ();
        }

        @Override
        public void setX(double value) {
            ((CPacketPlayerAccessor) getMeshValue()).setX(value);
        }

        @Override
        public void setY(double value) {
            ((CPacketPlayerAccessor) getMeshValue()).setY(value);
        }

        @Override
        public void setZ(double value) {
            ((CPacketPlayerAccessor) getMeshValue()).setZ(value);
        }

        @Override
        public float getYaw() {
            return ((CPacketPlayerAccessor) getMeshValue()).getYaw();
        }

        @Override
        public float getPitch() {
            return ((CPacketPlayerAccessor) getMeshValue()).getPitch();
        }

        @Override
        public void setYaw(float value) {
            ((CPacketPlayerAccessor) getMeshValue()).setYaw(value);
        }

        @Override
        public void setPitch(float value) {
            ((CPacketPlayerAccessor) getMeshValue()).setPitch(value);
        }
    }
}
