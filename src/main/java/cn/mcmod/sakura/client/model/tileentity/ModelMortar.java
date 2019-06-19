package cn.mcmod.sakura.client.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * ModelMortar - bagu
 * Created using Tabula 7.0.0
 */
@SideOnly(Side.CLIENT)
public class ModelMortar extends ModelBase {
    public ModelRenderer block1;
    public ModelRenderer block2;
    public ModelRenderer handle;

    public ModelMortar() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.handle = new ModelRenderer(this, 0, 0);
        this.handle.setRotationPoint(4.0F, 2.0F, 5.0F);
        this.handle.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.block1 = new ModelRenderer(this, 0, 0);
        this.block1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.block1.addBox(-8.0F, 0.0F, -8.0F, 16, 8, 16, 0.0F);
        this.block2 = new ModelRenderer(this, 0, 24);
        this.block2.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.block2.addBox(-8.0F, -8.0F, -8.0F, 16, 8, 16, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.handle.render(f5);
        this.block1.render(f5);
        this.block2.render(f5);
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
