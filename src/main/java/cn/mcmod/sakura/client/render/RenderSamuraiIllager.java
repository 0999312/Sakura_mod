package cn.mcmod.sakura.client.render;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.ModelSamuraiIllager;
import cn.mcmod.sakura.entity.EntitySamuraiIllager;
import net.minecraft.client.model.ModelIllager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSamuraiIllager extends RenderLiving<EntityMob> {
    private static final ResourceLocation ILLAGER_TEXTURE = new ResourceLocation(SakuraMain.MODID, "textures/entity/illager/samuraiillager.png");

    public RenderSamuraiIllager(RenderManager p_i47477_1_) {
        super(p_i47477_1_, new ModelSamuraiIllager(0.0F, 0.0F, 64, 64), 0.5F);
        this.addLayer(new LayerHeldItem(this) {
            public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
                if ((((EntitySamuraiIllager) entitylivingbaseIn).isAggressive())) {
                    super.doRenderLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
                }
            }

            protected void translateToHand(EnumHandSide p_191361_1_) {
                ((ModelIllager) this.livingEntityRenderer.getMainModel()).getArm(p_191361_1_).postRender(0.0625F);
            }
        });

        ((ModelIllager) this.getMainModel()).hat.showModel = false;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMob entity) {
        return ILLAGER_TEXTURE;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityMob entitylivingbaseIn, float partialTickTime) {
        float f = 0.9375F;
        GlStateManager.scale(0.9375F, 0.9375F, 0.9375F);
    }

}