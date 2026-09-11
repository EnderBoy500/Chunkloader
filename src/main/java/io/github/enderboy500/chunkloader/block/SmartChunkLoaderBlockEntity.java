package io.github.enderboy500.chunkloader.block;

import io.github.enderboy500.chunkloader.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class SmartChunkLoaderBlockEntity extends BlockEntity {
    private float rotation = 0;

    public SmartChunkLoaderBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlocks.SMART_CHUNK_LOADER_BE, blockPos, blockState);
    }

    public float getRenderingRotation() {
        BlockState state = level.getBlockState(worldPosition);
        if (state.getValue(BlockStateProperties.POWERED)) {
            rotation += 16f;
        } else {
            rotation += 0.2f;
        }
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public void tick(Level level, BlockPos pos) {
        if (level.getBlockState(pos).is(ModBlocks.SMART_CHUNK_LOADER) && level.getBlockState(pos).getValue(ChunkLoaderBlock.POWERED)) {
            ChunkPos chunkPos = level.getChunk(pos).getPos();
            if (level instanceof ServerLevel serverLevel) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        serverLevel.setChunkForced(chunkPos.x + i, chunkPos.z + j, true);
                    }
                }
            }
        }
    }
}
