package io.github.enderboy500.chunkloader;

import io.github.enderboy500.chunkloader.block.ChunkLoaderBlock;
import io.github.enderboy500.chunkloader.block.ChunkLoaderBlockEntity;
import io.github.enderboy500.chunkloader.block.SmartChunkLoaderBlock;
import io.github.enderboy500.chunkloader.block.SmartChunkLoaderBlockEntity;
import net.enderboy500.enderlib.registry.template.EBlockRegistry;
import net.enderboy500.enderlib.registry.template.EEntityRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public interface ModBlocks {
    EBlockRegistry register = new EBlockRegistry(TheChunkLoaderMod.MOD_ID);
    EEntityRegistry registerBlockEntity = new EEntityRegistry(TheChunkLoaderMod.MOD_ID);

    Block CHUNK_LOADER = register.registerBlockWithItem("chunk_loader", ChunkLoaderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BEACON), false);
    Block SMART_CHUNK_LOADER = register.registerBlockWithItem("smart_chunk_loader", SmartChunkLoaderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BEACON), false);

    BlockEntityType<ChunkLoaderBlockEntity> CHUNK_LOADER_BE = (BlockEntityType<ChunkLoaderBlockEntity>) registerBlockEntity.registerBlockEntity("chunk_loader", ChunkLoaderBlockEntity::new,
            CHUNK_LOADER);

    BlockEntityType<SmartChunkLoaderBlockEntity> SMART_CHUNK_LOADER_BE = (BlockEntityType<SmartChunkLoaderBlockEntity>) registerBlockEntity.registerBlockEntity("smart_chunk_loader", SmartChunkLoaderBlockEntity::new,
            SMART_CHUNK_LOADER);

    static void load() {}
}
