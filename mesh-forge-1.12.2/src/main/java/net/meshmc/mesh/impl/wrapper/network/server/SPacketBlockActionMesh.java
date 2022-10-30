package net.meshmc.mesh.impl.wrapper.network.server;

import net.meshmc.mesh.api.block.Block;
import net.meshmc.mesh.api.math.BlockPos;
import net.meshmc.mesh.api.network.server.SPacketBlockAction;
import net.meshmc.mesh.impl.util.Mappings;
import net.meshmc.mesh.impl.wrapper.network.PacketMesh;

import javax.annotation.Nullable;

public class SPacketBlockActionMesh extends PacketMesh.Server<net.minecraft.network.play.server.SPacketBlockAction> implements SPacketBlockAction {
    public SPacketBlockActionMesh(net.minecraft.network.play.server.SPacketBlockAction value) {
        super(value);
    }

    @Override
    public S2C getType() {
        return S2C.BlockAction;
    }

    @Override
    public BlockPos getBlockPos() {
        return (BlockPos) getMeshValue().getBlockPosition();
    }

    @Override
    public int getInstrument() {
        return getMeshValue().getData1();
    }

    @Override
    public int getPitch() {
        return getMeshValue().getData2();
    }

    Block block;
    @Override
    public Block getBlock() {
        if(block == null) block = Mappings.block(getMeshValue().getBlockType());
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
