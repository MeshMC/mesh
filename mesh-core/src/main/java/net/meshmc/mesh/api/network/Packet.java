package net.meshmc.mesh.api.network;

import io.netty.buffer.ByteBuf;
import net.meshmc.mesh.statics.StaticPackets;
import net.meshmc.mesh.util.MCVersion;

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
                MCVersion.v1_19_1, 0x05,
                MCVersion.v1_19, 0x04,
                MCVersion.v1_18_2, 0x03,
                MCVersion.v1_12_2, 0x02
        ),

        ConfirmTeleport(
                StaticPackets::createCPacketConfirmTeleport,
                MCVersion.v1_18_2, 0x00,
                MCVersion.v1_12_2, 0x00
        ),

        HandSwing(
                StaticPackets::createCPacketHandSwing,
                MCVersion.v1_18_2, 0x2C,
                MCVersion.v1_12_2, 0x1D
        ),

        Input(
                StaticPackets::createCPacketInput,
                MCVersion.v1_18_2, 0x1C,
                MCVersion.v1_12_2, 0x16
        ),

        MovePlayerOnGround(
                StaticPackets::createCPacketMovePlayerOnGround,
                MCVersion.v1_18_2, 0x14,
                MCVersion.v1_12_2, 0x0C
        ),
        MovePlayerPosition(
                StaticPackets::createCPacketMovePlayerPosition,
                MCVersion.v1_18_2, 0x11,
                MCVersion.v1_12_2, 0x0D
        ),
        MovePlayerPositionRotation(
                StaticPackets::createCPacketMovePlayerPositionRotation,
                MCVersion.v1_18_2, 0x12,
                MCVersion.v1_12_2, 0x0E
        ),
        MovePlayerRotation(
                StaticPackets::createCPacketMovePlayerRotation,
                MCVersion.v1_18_2, 0x13,
                MCVersion.v1_12_2, 0x0F
        ),

        MoveVehicle(
                StaticPackets::createCPacketMoveVehicle,
                MCVersion.v1_18_2, 0x15,
                MCVersion.v1_12_2, 0x10
        ),

        SteerBoat(
                StaticPackets::createCPacketSteerBoat,
                MCVersion.v1_18_2, 0x16,
                MCVersion.v1_12_2, 0x11
        ),

        UseBlock(
                StaticPackets::createCPacketUseBlock,
                MCVersion.v1_18_2, 0x2E,
                MCVersion.v1_12_2, 0x1F
        ),
        UseEntity(
                StaticPackets::createCPacketUseEntity,
                MCVersion.v1_18_2, 0x0D,
                MCVersion.v1_12_2, 0x0A
        ),
        UseItem(
                StaticPackets::createCPacketUseItem,
                MCVersion.v1_18_2, 0x2F,
                MCVersion.v1_12_2, 0x20
        ),
        ;

        private final Function<ByteBuf, Packet.Client> packetInstantiator;
        private final EnumMap<MCVersion, Integer> versionIDs;

        C2S(Function<ByteBuf, Packet.Client> packetInstantiator, Object... versions) {
            this.packetInstantiator = packetInstantiator;
            this.versionIDs = new EnumMap<>(MCVersion.class);

            if(versions.length % 2 == 0) throw new RuntimeException("Uneven number of Objects passed in C2S enum instantiator");

            MCVersion v = null;
            for(Object a: versions) {
                if(v == null) {
                    if(!(a instanceof MCVersion))
                        throw new RuntimeException();

                    v = (MCVersion) a;
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

        public int getVersionID(MCVersion version) {
            return versionIDs.get(version);
        }
    }

    enum S2C {
        AdvancementUpdate(
                StaticPackets::createSPacketAdvancementUpdate,
                MCVersion.v1_18_2, 0x63,
                MCVersion.v1_12_2, 0x4D
        ),
        BlockAction(
                StaticPackets::createSPacketBlockAction,
                MCVersion.v1_18_2, 0x0B,
                MCVersion.v1_12_2, 0x0A
        ),
        BlockUpdate(
                StaticPackets::createSPacketBlockUpdate,
                MCVersion.v1_18_2, 0x0C,
                MCVersion.v1_12_2, 0x0B
        ),
        BreakProgress(
                StaticPackets::createSPacketBreakProgress,
                MCVersion.v1_18_2, 0x09,
                MCVersion.v1_12_2, 0x08
        ),
        PlayerPositionRotation(
                StaticPackets::createSPacketPlayerPositionRotation,
                MCVersion.v1_18_2, 0x38,
                MCVersion.v1_12_2, 0x2F
        ),
        TileEntityUpdate(
                StaticPackets::createSPacketTileEntityUpdate,
                MCVersion.v1_18_2, 0x0A,
                MCVersion.v1_12_2, 0x09
        ),
        ;

        private final Function<ByteBuf, Packet.Server> packetInstantiator;
        private final EnumMap<MCVersion, Integer> versionIDs;

        S2C(Function<ByteBuf, Packet.Server> packetInstantiator, Object... versions) {
            this.packetInstantiator = packetInstantiator;
            this.versionIDs = new EnumMap<>(MCVersion.class);

            if(versions.length % 2 == 0) throw new RuntimeException("Uneven number of Objects passed in C2S enum instantiator");

            MCVersion v = null;
            for(Object a: versions) {
                if(v == null) {
                    if(!(a instanceof MCVersion))
                        throw new RuntimeException();

                    v = (MCVersion) a;
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

        public int getVersionID(MCVersion version) {
            return versionIDs.get(version);
        }
    }
}
