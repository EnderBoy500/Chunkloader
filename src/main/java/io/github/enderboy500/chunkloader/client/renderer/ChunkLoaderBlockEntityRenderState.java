package io.github.enderboy500.chunkloader.client.renderer;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class ChunkLoaderBlockEntityRenderState extends BlockEntityRenderState {
    public BlockPos lightPosition;
    public Level level;
    public float rotation;
    public final ItemStackRenderState itemRenderState = new ItemStackRenderState();
}
