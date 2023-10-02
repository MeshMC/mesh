package net.meshmc.mesh.api.network;

import io.netty.buffer.ByteBuf;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.GameVersion;

import java.util.EnumMap;
import java.util.function.Function;

public interface Packet {
    void write(ByteBuf buf);

    interface Client extends Packet {
        C2S getType();
    }

    interface Server extends Packet {
        S2C getType();
    }

    enum C2S {
        ChatMessage(
                StaticPackets::createCPacketChatMessage,
                GameVersion.v1_19_1, 0x05,
                GameVersion.v1_19, 0x04,
                GameVersion.v1_18_2, 0x03,
                GameVersion.v1_12_2, 0x02
        ),

        ConfirmTeleport(
                StaticPackets::createCPacketConfirmTeleport,
                GameVersion.v1_18_2, 0x00,
                GameVersion.v1_12_2, 0x00
        ),

        HandSwing(
                StaticPackets::createCPacketHandSwing,
                GameVersion.v1_18_2, 0x2C,
                GameVersion.v1_12_2, 0x1D
        ),

        Input(
                StaticPackets::createCPacketInput,
                GameVersion.v1_18_2, 0x1C,
                GameVersion.v1_12_2, 0x16
        ),

        MovePlayerOnGround(
                StaticPackets::createCPacketMovePlayerOnGround,
                GameVersion.v1_18_2, 0x14,
                GameVersion.v1_12_2, 0x0C
        ),
        MovePlayerPosition(
                StaticPackets::createCPacketMovePlayerPosition,
                GameVersion.v1_18_2, 0x11,
                GameVersion.v1_12_2, 0x0D
        ),
        MovePlayerPositionRotation(
                StaticPackets::createCPacketMovePlayerPositionRotation,
                GameVersion.v1_18_2, 0x12,
                GameVersion.v1_12_2, 0x0E
        ),
        MovePlayerRotation(
                StaticPackets::createCPacketMovePlayerRotation,
                GameVersion.v1_18_2, 0x13,
                GameVersion.v1_12_2, 0x0F
        ),

        MoveVehicle(
                StaticPackets::createCPacketMoveVehicle,
                GameVersion.v1_18_2, 0x15,
                GameVersion.v1_12_2, 0x10
        ),

        SteerBoat(
                StaticPackets::createCPacketSteerBoat,
                GameVersion.v1_18_2, 0x16,
                GameVersion.v1_12_2, 0x11
        ),

        UseBlock(
                StaticPackets::createCPacketUseBlock,
                GameVersion.v1_18_2, 0x2E,
                GameVersion.v1_12_2, 0x1F
        ),
        UseEntity(
                StaticPackets::createCPacketUseEntity,
                GameVersion.v1_18_2, 0x0D,
                GameVersion.v1_12_2, 0x0A
        ),
        UseItem(
                StaticPackets::createCPacketUseItem,
                GameVersion.v1_18_2, 0x2F,
                GameVersion.v1_12_2, 0x20
        ),
        ;

        private final Function<ByteBuf, Packet.Client> packetInstantiator;
        private final EnumMap<GameVersion, Integer> versionIDs;

        C2S(Function<ByteBuf, Packet.Client> packetInstantiator, Object... versions) {
            this.packetInstantiator = packetInstantiator;
            this.versionIDs = new EnumMap<>(GameVersion.class);

            if(versions.length % 2 == 0) throw new RuntimeException("Uneven number of Objects passed in C2S enum instantiator");

            GameVersion v = null;
            for(Object a: versions) {
                if(v == null) {
                    if(!(a instanceof GameVersion))
                        throw new RuntimeException();

                    v = (GameVersion) a;
                }
                else {
                    if(!(a instanceof Integer))
                        throw new RuntimeException();

                    versionIDs.put(v, (Integer) a);
                    v = null;
                }
            }
        }

        public Packet.Client create(ByteBuf buf) {
            return packetInstantiator.apply(buf);
        }

        public int getVersionID(GameVersion version) {
            return versionIDs.get(version);
        }
    }

    enum S2C {
        AdvancementUpdate(
                StaticPackets::createSPacketAdvancementUpdate,
                GameVersion.v1_18_2, 0x63,
                GameVersion.v1_12_2, 0x4D
        ),
        BlockAction(
                StaticPackets::createSPacketBlockAction,
                GameVersion.v1_18_2, 0x0B,
                GameVersion.v1_12_2, 0x0A
        ),
        BlockUpdate(
                StaticPackets::createSPacketBlockUpdate,
                GameVersion.v1_18_2, 0x0C,
                GameVersion.v1_12_2, 0x0B
        ),
        BreakProgress(
                StaticPackets::createSPacketBreakProgress,
                GameVersion.v1_18_2, 0x09,
                GameVersion.v1_12_2, 0x08
        ),
        PlayerPositionRotation(
                StaticPackets::createSPacketPlayerPositionRotation,
                GameVersion.v1_18_2, 0x38,
                GameVersion.v1_12_2, 0x2F
        ),
        TileEntityUpdate(
                StaticPackets::createSPacketTileEntityUpdate,
                GameVersion.v1_18_2, 0x0A,
                GameVersion.v1_12_2, 0x09
        ),
        ;

        private final Function<ByteBuf, Packet.Server> packetInstantiator;
        private final EnumMap<GameVersion, Integer> versionIDs;

        S2C(Function<ByteBuf, Packet.Server> packetInstantiator, Object... versions) {
            this.packetInstantiator = packetInstantiator;
            this.versionIDs = new EnumMap<>(GameVersion.class);

            if(versions.length % 2 == 0) throw new RuntimeException("Uneven number of Objects passed in C2S enum instantiator");

            GameVersion v = null;
            for(Object a: versions) {
                if(v == null) {
                    if(!(a instanceof GameVersion))
                        throw new RuntimeException();

                    v = (GameVersion) a;
                }
                else {
                    if(!(a instanceof Integer))
                        throw new RuntimeException();

                    versionIDs.put(v, (Integer) a);
                    v = null;
                }
            }
        }

        public Packet.Server create(ByteBuf buf) {
            return packetInstantiator.apply(buf);
        }

        public int getVersionID(GameVersion version) {
            return versionIDs.get(version);
        }
    }
}
