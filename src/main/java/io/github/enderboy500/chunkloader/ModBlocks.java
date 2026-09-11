package io.github.enderboy500.chunkloader;

import io.github.ciph3rj.cipherlib.helper.RegistryHelper;
import io.github.enderboy500.chunkloader.block.ChunkLoaderBlock;
import io.github.enderboy500.chunkloader.block.ChunkLoaderBlockEntity;
import io.github.enderboy500.chunkloader.block.SmartChunkLoaderBlock;
import io.github.enderboy500.chunkloader.block.SmartChunkLoaderBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public interface ModBlocks {
    Block CHUNK_LOADER = RegistryHelper.registerBlockWithItem("chunk_loader", ChunkLoaderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BEACON));
    Block SMART_CHUNK_LOADER = RegistryHelper.registerBlockWithItem("smart_chunk_loader", SmartChunkLoaderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BEACON));

    BlockEntityType<ChunkLoaderBlockEntity> CHUNK_LOADER_BE = (BlockEntityType<ChunkLoaderBlockEntity>) RegistryHelper.registerBlockEntity("chunk_loader", ChunkLoaderBlockEntity::new,
            CHUNK_LOADER);

    BlockEntityType<SmartChunkLoaderBlockEntity> SMART_CHUNK_LOADER_BE = (BlockEntityType<SmartChunkLoaderBlockEntity>) RegistryHelper.registerBlockEntity("smart_chunk_loader", SmartChunkLoaderBlockEntity::new,
            SMART_CHUNK_LOADER);

    static void load() {}
}
