package net.meshmc.mesh.impl.wrapper.network.client;

import net.meshmc.mesh.api.network.client.CPacketMovePlayer;
import net.meshmc.mesh.impl.mixin.accessors.packet.PlayerMoveC2SPacketAccessor;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public abstract class CPacketMovePlayerMesh<T extends PlayerMoveC2SPacket> extends PacketMesh.Client<T> implements CPacketMovePlayer {
    public CPacketMovePlayerMesh(T value) {
        super(value);
    }

    public static class OnGround<T extends PlayerMoveC2SPacket> extends CPacketMovePlayerMesh<T> implements CPacketMovePlayer.OnGround {
        public OnGround(T value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerOnGround;
        }

        @Override
        public boolean isOnGround() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).isOnGround();
        }

        @Override
        public void setOnGround(boolean value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setOnGround(value);
        }
    }

    public static class Position extends CPacketMovePlayerMesh.OnGround<PlayerMoveC2SPacket.PositionAndOnGround> implements CPacketMovePlayer.Position {
        public Position(PlayerMoveC2SPacket.PositionAndOnGround value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerPosition;
        }

        @Override
        public double getX() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getX();
        }

        @Override
        public double getY() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getY();
        }

        @Override
        public double getZ() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getZ();
        }

        @Override
        public void setX(double value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setX(value);
        }

        @Override
        public void setY(double value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setY(value);
        }

        @Override
        public void setZ(double value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setZ(value);
        }
    }

    public static class Rotation extends CPacketMovePlayerMesh.OnGround<PlayerMoveC2SPacket.LookAndOnGround> implements CPacketMovePlayer.Rotation {
        public Rotation(PlayerMoveC2SPacket.LookAndOnGround value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerRotation;
        }

        @Override
        public float getYaw() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getYaw();
        }

        @Override
        public float getPitch() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getPitch();
        }

        @Override
        public void setYaw(float value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setYaw(value);
        }

        @Override
        public void setPitch(float value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setPitch(value);
        }
    }

    public static class PositionRotation extends CPacketMovePlayerMesh.OnGround<PlayerMoveC2SPacket.Full> implements CPacketMovePlayer.PositionRotation {
        public PositionRotation(PlayerMoveC2SPacket.Full value) {
            super(value);
        }

        @Override
        public C2S getType() {
            return C2S.MovePlayerPositionRotation;
        }

        @Override
        public double getX() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getX();
        }

        @Override
        public double getY() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getY();
        }

        @Override
        public double getZ() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getZ();
        }

        @Override
        public void setX(double value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setX(value);
        }

        @Override
        public void setY(double value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setY(value);
        }

        @Override
        public void setZ(double value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setZ(value);
        }

        @Override
        public float getYaw() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getYaw();
        }

        @Override
        public float getPitch() {
            return ((PlayerMoveC2SPacketAccessor) getMeshValue()).getPitch();
        }

        @Override
        public void setYaw(float value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setYaw(value);
        }

        @Override
        public void setPitch(float value) {
            ((PlayerMoveC2SPacketAccessor) getMeshValue()).setPitch(value);
        }
    }
}
