package cn.mcmod.sakura.client.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPot - bagu_chan
 * Created using Tabula 7.0.0
 */
public class ModelPot extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer ironBar;
    public ModelRenderer ironBar2;
    public ModelRenderer ironBar3;
    public ModelRenderer ironBar4;
    public ModelRenderer pot1;
    public ModelRenderer base2;
    public ModelRenderer base3;
    public ModelRenderer pot2;
    public ModelRenderer pot3;
    public ModelRenderer pot3_1;
    public ModelRenderer pot4;

    public ModelPot() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.ironBar3 = new ModelRenderer(this, 64, 8);
        this.ironBar3.setRotationPoint(6.5F, 16.0F, 6.5F);
        this.ironBar3.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.ironBar2 = new ModelRenderer(this, 64, 8);
        this.ironBar2.setRotationPoint(-6.5F, 16.0F, -6.5F);
        this.ironBar2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.pot3 = new ModelRenderer(this, 0, 30);
        this.pot3.setRotationPoint(0.0F, -1.0F, 5.0F);
        this.pot3.addBox(-6.0F, -7.0F, 0.0F, 12, 7, 1, 0.0F);
        this.pot3_1 = new ModelRenderer(this, 26, 30);
        this.pot3_1.setRotationPoint(6.0F, -7.0F, 0.0F);
        this.pot3_1.addBox(-0.5F, -1.0F, -6.0F, 1, 7, 12, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(0.0F, 15.8F, 0.0F);
        this.base.addBox(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
        this.base2 = new ModelRenderer(this, 64, 0);
        this.base2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.base2.addBox(-8.0F, -7.0F, 0.0F, 16, 7, 1, 0.0F);
        this.ironBar = new ModelRenderer(this, 64, 8);
        this.ironBar.setRotationPoint(6.5F, 16.0F, -6.5F);
        this.ironBar.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.ironBar4 = new ModelRenderer(this, 64, 8);
        this.ironBar4.setRotationPoint(-5.5F, 16.0F, 6.5F);
        this.ironBar4.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.pot1 = new ModelRenderer(this, 0, 17);
        this.pot1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.pot1.addBox(-6.0F, -1.0F, -6.0F, 12, 1, 12, 0.0F);
        this.pot2 = new ModelRenderer(this, 0, 30);
        this.pot2.setRotationPoint(0.0F, -1.0F, -6.0F);
        this.pot2.addBox(-6.0F, -7.0F, 0.0F, 12, 7, 1, 0.0F);
        this.pot4 = new ModelRenderer(this, 26, 30);
        this.pot4.setRotationPoint(-6.0F, -7.0F, 0.0F);
        this.pot4.addBox(-0.5F, -1.0F, -6.0F, 1, 7, 12, 0.0F);
        this.base3 = new ModelRenderer(this, 64, 0);
        this.base3.setRotationPoint(0.0F, 0.0F, 7.1F);
        this.base3.addBox(-8.0F, -7.0F, 0.0F, 16, 7, 1, 0.0F);
        this.pot1.addChild(this.pot3);
        this.pot1.addChild(this.pot3_1);
        this.base.addChild(this.base2);
        this.pot1.addChild(this.pot2);
        this.pot1.addChild(this.pot4);
        this.base.addChild(this.base3);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.ironBar3.render(f5);
        this.ironBar2.render(f5);
        this.base.render(f5);
        this.ironBar.render(f5);
        this.ironBar4.render(f5);
        this.pot1.render(f5);
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
