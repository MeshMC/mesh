package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.block.Block;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketBlockAction;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;
import net.minecraft.network.packet.s2c.play.BlockEventS2CPacket;
import org.jetbrains.annotations.Nullable;

public class SPacketBlockActionMesh extends PacketMesh.Server<BlockEventS2CPacket> implements SPacketBlockAction {
    public SPacketBlockActionMesh(BlockEventS2CPacket value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.BlockAction;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getPos();
    }

    @Override
    public int getInstrument() {
        return getMeshValue().getType();
    }

    @Override
    public int getPitch() {
        return getMeshValue().getData();
    }

    Block block;
    @Override
    public Block getBlock() {
        if(block == null) block = Mappings.block(getMeshValue().getBlock());
        return block;
    }

    Enum<?> blockVariant;
    @Nullable
    @Override
    public Enum<?> getBlockVariant() {
        // TODO: Map some blocks to variants without blockstate
        return blockVariant;
    }

    @Override
    public void setBlock(Block block, Enum<?> blockVariant) {
        this.block = block;
        this.blockVariant = blockVariant;
        // TODO: Handle reversing block / variant into MC block and set block
    }
}
