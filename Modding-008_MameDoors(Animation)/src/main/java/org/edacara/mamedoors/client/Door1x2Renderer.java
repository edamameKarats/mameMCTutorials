package org.edacara.mamedoors.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.model.data.EmptyModelData;
import org.edacara.mamedoors.blocks.Door1x2;
import org.edacara.mamedoors.blocks.be.Door1x2BE;

import java.util.Random;

public class Door1x2Renderer implements BlockEntityRenderer<Door1x2BE> {

    public Door1x2Renderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(Door1x2BE door1x2BE, float partialTicks, PoseStack poseStack,
                       MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
        Direction facing=door1x2BE.getBlockState().getValue(Door1x2.FACING);
        int delta;
        poseStack.pushPose();
        if(facing.equals(Direction.NORTH)) {poseStack.translate(0.5/16,0,0.5/16);delta=0;}
        else if(facing.equals(Direction.SOUTH)) {poseStack.translate(15.5/16,0,15.5/16);delta=180;}
        else if(facing.equals(Direction.EAST)) {poseStack.translate(15.5/16,0,0.5/16);delta=90;}
        else {poseStack.translate(0.5/16,0,15.5/16);delta=-90;}

        Quaternion rotation=new Quaternion(0,(float)Math.sin(Math.PI*(-door1x2BE.ticks-delta)/360),
                0,(float)Math.cos(Math.PI*(-door1x2BE.ticks-delta)/360));
        poseStack.mulPose(rotation);
        BlockRenderDispatcher dispatcher = Minecraft.getInstance().getBlockRenderer();
        BakedModel door= dispatcher.getBlockModel(door1x2BE.getBlockState().setValue(Door1x2.ISPART,true));
        VertexConsumer builder = bufferSource.getBuffer(RenderType.cutout());
        Level world = door1x2BE.getLevel();

        dispatcher.getModelRenderer().tesselateBlock(world, door, door1x2BE.getBlockState().setValue(Door1x2.ISPART,true),
                door1x2BE.getBlockPos(), poseStack, builder, false, new Random(), 0, 0, EmptyModelData.INSTANCE);
        poseStack.popPose();
    }
}

