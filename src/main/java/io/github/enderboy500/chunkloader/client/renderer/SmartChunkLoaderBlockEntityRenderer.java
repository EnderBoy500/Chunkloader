package io.github.enderboy500.chunkloader.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.github.enderboy500.chunkloader.ModBlocks;
import io.github.enderboy500.chunkloader.block.ChunkLoaderBlockEntity;
import io.github.enderboy500.chunkloader.block.SmartChunkLoaderBlockEntity;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class SmartChunkLoaderBlockEntityRenderer implements BlockEntityRenderer<SmartChunkLoaderBlockEntity, ChunkLoaderBlockEntityRenderState> {
    private final ItemModelResolver itemModelResolver;

    public SmartChunkLoaderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public ChunkLoaderBlockEntityRenderState createRenderState() {
        return new ChunkLoaderBlockEntityRenderState();
    }

    @Override
    public void extractRenderState(SmartChunkLoaderBlockEntity blockEntity, ChunkLoaderBlockEntityRenderState state, float f, Vec3 vec3, ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, f, vec3, crumblingOverlay);

        state.level = blockEntity.getLevel();
        BlockPos pos = state.blockPos;
        BlockState blockState = state.level.getBlockState(state.blockPos);
        state.lightPosition = blockEntity.getBlockPos();
        Level world = state.level;
        if (!blockState.isAir()) state.rotation = blockEntity.getRenderingRotation();

        assert world != null;
        if (world.getBlockEntity(pos) != null)
            itemModelResolver.updateForTopItem(state.itemRenderState, Items.NETHER_STAR.getDefaultInstance(), ItemDisplayContext.FIXED, world,
                    null, 0);
    }

    public static int getLightLevel(Level world, BlockPos pos) {
        int bLight = world.getBrightness(LightLayer.BLOCK, pos);
        int sLight = world.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }

    @Override
    public void submit(ChunkLoaderBlockEntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        BlockState blockState = state.level.getBlockState(state.blockPos);

        if (!blockState.isAir()) {
            poseStack.pushPose();

                    poseStack.translate(0.5f, 0.65f, 0.5f);
            poseStack.scale(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(state.level.getBlockEntity(state.blockPos, ModBlocks.SMART_CHUNK_LOADER_BE).get().getRenderingRotation()));

            state.itemRenderState.submit(poseStack, submitNodeCollector, getLightLevel(state.level, state.blockPos), OverlayTexture.NO_OVERLAY, 0);

            poseStack.popPose();
        }
    }
}