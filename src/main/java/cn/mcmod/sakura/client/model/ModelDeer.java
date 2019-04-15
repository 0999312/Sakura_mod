package cn.mcmod.sakura.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelDeer - bagu
 * Created using Tabula 7.0.0
 */
public class ModelDeer extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer legR;
    public ModelRenderer legL;
    public ModelRenderer backlegR;
    public ModelRenderer backlegL;
    public ModelRenderer head;
    public ModelRenderer head2;
    public ModelRenderer earR;
    public ModelRenderer earL;

    public ModelDeer() {
        super();
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head2 = new ModelRenderer(this, 20, 20);
        this.head2.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.head2.addBox(-2.0F, -1.5F, -3.0F, 4, 3, 3, 0.0F);
        this.neck = new ModelRenderer(this, 27, 0);
        this.neck.setRotationPoint(0.0F, -1.0F, 2.0F);
        this.neck.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(neck, -1.0927506446736497F, 0.0F, 0.0F);
        this.backlegR = new ModelRenderer(this, 40, 20);
        this.backlegR.setRotationPoint(-2.0F, 2.0F, 10.0F);
        this.backlegR.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.backlegL = new ModelRenderer(this, 48, 20);
        this.backlegL.setRotationPoint(2.0F, 2.0F, 10.7F);
        this.backlegL.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.head = new ModelRenderer(this, 0, 20);
        this.head.setRotationPoint(0.0F, -1.1F, -5.1F);
        this.head.addBox(-2.5F, -3.0F, -5.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(head, 1.0821041362364843F, 0.0F, 0.0F);
        this.legL = new ModelRenderer(this, 48, 11);
        this.legL.setRotationPoint(2.0F, 2.0F, 2.0F);
        this.legL.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.legR = new ModelRenderer(this, 40, 11);
        this.legR.setRotationPoint(-2.0F, 2.0F, 2.0F);
        this.legR.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.earL = new ModelRenderer(this, 0, 3);
        this.earL.setRotationPoint(1.6F, -4.0F, -2.0F);
        this.earL.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 15.0F, -5.5F);
        this.body.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 13, 0.0F);
        this.earR = new ModelRenderer(this, 0, 0);
        this.earR.setRotationPoint(-1.6F, -4.0F, -2.0F);
        this.earR.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.neck.addChild(this.head);
        this.head.addChild(this.earR);
        this.body.addChild(this.legR);
        this.body.addChild(this.neck);
        this.head.addChild(this.head2);
        this.body.addChild(this.backlegL);
        this.body.addChild(this.legL);
        this.body.addChild(this.backlegR);
        this.head.addChild(this.earL);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        if(this.isChild){
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.body.render(scale);
            GlStateManager.popMatrix();
        }else {
            this.body.render(scale);
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.head.rotateAngleX = 1.0821041362364843F;
        this.neck.rotateAngleX = (headPitch * 0.017453292F) -1.0927506446736497F;
        this.neck.rotateAngleY = (netHeadYaw * 0.017453292F);
        this.legR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.backlegR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.backlegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
