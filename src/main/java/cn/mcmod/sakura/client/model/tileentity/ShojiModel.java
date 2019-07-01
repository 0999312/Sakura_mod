package cn.mcmod.sakura.client.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ShojiModel extends ModelBase {
    private ModelRenderer main;

    public ShojiModel() {
        textureWidth = 64;
        textureHeight = 64;

        main = new ModelRenderer(this, 0, 0);
        main.addBox(-8F, -8F, -1F, 16, 32, 2);
        main.setRotationPoint(0F, 0F, 0F);
        main.setTextureSize(64, 64);
        main.mirror = true;
        setRotation(main, 0F, 0F, 0F);
    }

    public void render(float scale) {
        main.rotateAngleY = (float) Math.PI / 2;
        main.offsetY = -24f;
        main.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
