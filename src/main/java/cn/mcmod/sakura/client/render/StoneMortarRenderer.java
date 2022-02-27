package cn.mcmod.sakura.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;

import cn.mcmod.sakura.SakuraMod;
import cn.mcmod.sakura.block.BlockRegistry;
import cn.mcmod.sakura.block.entity.StoneMortarBlockEntity;
import cn.mcmod.sakura.block.machines.StoneMortarBlock;
import cn.mcmod.sakura.client.layers.LayerRegistry;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class StoneMortarRenderer implements BlockEntityRenderer<StoneMortarBlockEntity> {

    private final ModelPart top;
    private final ModelPart bb_main;

    public StoneMortarRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart root = context.bakeLayer(LayerRegistry.STONE_MORTAR);
        this.top = root.getChild("top");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("top",
                CubeListBuilder.create().texOffs(0, 24)
                        .addBox(-8.0F, -16.0F, -8.0F, 16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-6.0F, -22.0F, 4.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));
        partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -8.0F,
                16.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void render(StoneMortarBlockEntity tileEntity, float partialTicks, PoseStack poseStack,
            MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        Level world = tileEntity.getLevel();
        boolean flag = world != null;
        BlockState blockstate = flag ? tileEntity.getBlockState()
                : BlockRegistry.STONE_MORTAR.get().defaultBlockState();
        if (blockstate.getBlock() instanceof StoneMortarBlock) {
            poseStack.pushPose();
            poseStack.translate(0.5D, 1.5D, 0.5D);
            poseStack.mulPose(Vector3f.XP.rotationDegrees(180));
            top.setRotation(0F, ((float) (Math.PI * tileEntity.getRotation()) / 180.0F), 0F);
            ResourceLocation TEXTURE = new ResourceLocation(SakuraMod.MODID, "textures/entity/tileentity/mortar.png");
            this.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entitySolid(TEXTURE)), combinedLight,
                    combinedOverlay);
            poseStack.popPose();
        }
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay) {
        top.render(poseStack, buffer, packedLight, packedOverlay);
        bb_main.render(poseStack, buffer, packedLight, packedOverlay);
    }

}
