package org.edacara.mamecontainers.client.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.edacara.mamecontainers.MameContainers;
import org.edacara.mamecontainers.blocks.containers.MameMillMenu;

@OnlyIn(Dist.CLIENT)
public class MameMillScreen extends AbstractContainerScreen<MameMillMenu> {
    private static final ResourceLocation TEXTURE
            = new ResourceLocation(MameContainers.modid, "textures/gui/mamemill_gui.png");
   private final ResourceLocation texture;

    public MameMillScreen(MameMillMenu mameMillMenu, Inventory inventory, Component component) {
        super(mameMillMenu,inventory,component);
        this.texture=TEXTURE;
    }

    public void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.texture);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        int l = this.menu.getBurnProgress();
        this.blit(poseStack, i + 79, j + 34, 176, 14, l + 1, 16);
    }
}