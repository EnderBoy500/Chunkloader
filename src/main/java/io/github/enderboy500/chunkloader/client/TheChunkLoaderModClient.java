package io.github.enderboy500.chunkloader.client;

import io.github.enderboy500.chunkloader.ModBlocks;
import io.github.enderboy500.chunkloader.block.SmartChunkLoaderBlockEntity;
import io.github.enderboy500.chunkloader.client.renderer.ChunkLoaderBlockEntityRenderer;
import io.github.enderboy500.chunkloader.client.renderer.SmartChunkLoaderBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class TheChunkLoaderModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, ModBlocks.CHUNK_LOADER, ModBlocks.SMART_CHUNK_LOADER);

        BlockEntityRenderers.register(ModBlocks.CHUNK_LOADER_BE, ChunkLoaderBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlocks.SMART_CHUNK_LOADER_BE, SmartChunkLoaderBlockEntityRenderer::new);
    }
}
