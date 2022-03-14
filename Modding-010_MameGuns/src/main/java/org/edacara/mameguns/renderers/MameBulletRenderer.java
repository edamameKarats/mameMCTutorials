package org.edacara.mameguns.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.edacara.mameguns.MameGuns;
import org.edacara.mameguns.projectiles.MameBulletProjectile;

public class MameBulletRenderer<T extends MameBulletProjectile> extends EntityRenderer<T> {
    public static final ResourceLocation BULLET_LOCATION
            = new ResourceLocation(MameGuns.modid,"textures/entity/projectiles/mame_bullet.png");

    public MameBulletRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTextureLocation(T projectile) {
        return BULLET_LOCATION;
    }

    public void render(T projectile, float vf1, float vf2, PoseStack poseStack, MultiBufferSource multiBufferSource, int vi1) {
        poseStack.pushPose();
        poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(vf2, projectile.yRotO, projectile.getYRot()) - 90.0F));
        poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(vf2, projectile.xRotO, projectile.getXRot())));
        int i = 0;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = 0.0F;
        float f3 = 0.15625F;
        float f4 = 0.0F;
        float f5 = 0.15625F;
        float f6 = 0.15625F;
        float f7 = 0.3125F;
        float f8 = 0.05625F;
        float f9 = (float)projectile.shakeTime - vf2;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(f10));
        }

        poseStack.mulPose(Vector3f.XP.rotationDegrees(45.0F));
        poseStack.scale(0.05625F, 0.05625F, 0.05625F);
        poseStack.translate(-4.0D, 0.0D, 0.0D);
        VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutout(this.getTextureLocation(projectile)));
        PoseStack.Pose posestack$pose = poseStack.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, vi1);
        this.vertex(matrix4f, matrix3f, vertexconsumer,
                -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, vi1);

        for(int j = 0; j < 4; ++j) {
            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            this.vertex(matrix4f, matrix3f, vertexconsumer,
                    -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, vi1);
            this.vertex(matrix4f, matrix3f, vertexconsumer,
                    8, -2, 0, 0.5F, 0.0F, 0, 1, 0, vi1);
            this.vertex(matrix4f, matrix3f, vertexconsumer,
                    8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, vi1);
            this.vertex(matrix4f, matrix3f, vertexconsumer,
                    -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, vi1);
        }

        poseStack.popPose();
        super.render(projectile, vf1, vf2, poseStack, multiBufferSource, vi1);
    }

    public void vertex(Matrix4f matrix4f, Matrix3f matrix3f, VertexConsumer consumer, int vi1, int vi2, int vi3,
                       float vf1, float vf2, int vi4, int vi5, int vi6, int vi7) {
        consumer.vertex(matrix4f, (float)vi1, (float)vi2, (float)vi3).color(255, 255, 255, 255)
                .uv(vf1, vf2).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(vi7)
                .normal(matrix3f, (float)vi4, (float)vi6, (float)vi5).endVertex();
    }
}
