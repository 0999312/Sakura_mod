package cn.mcmod.sakura.client.model;

import net.minecraft.client.model.ModelIllager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.AbstractIllager;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSamuraiIllager extends ModelIllager {
    public ModelSamuraiIllager(float scaleFactor, float p_i47227_2_, int textureWidthIn, int textureHeightIn) {
        super(scaleFactor, p_i47227_2_, textureWidthIn, textureHeightIn);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.arms.rotationPointY = 3.0F;
        this.arms.rotationPointZ = -1.0F;
        this.arms.rotateAngleX = -0.75F;
        this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.leg0.rotateAngleY = 0.0F;
        this.leg1.rotateAngleY = 0.0F;
        AbstractIllager.IllagerArmPose abstractillager$illagerarmpose = ((AbstractIllager) entityIn).getArmPose();

        if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.ATTACKING) {
            float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
            float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);
            this.rightArm.rotateAngleZ = -0.3363323129985824F;
            this.leftArm.rotateAngleZ = 0.3363323129985824F;
            this.rightArm.rotateAngleY = -0.3363323129985824F;
            this.leftArm.rotateAngleY = 0.3363323129985824F;

            if (((EntityLivingBase) entityIn).getPrimaryHand() == EnumHandSide.RIGHT) {
                this.rightArm.rotateAngleX = -1.4849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.leftArm.rotateAngleX = -1.4849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.rightArm.rotateAngleX += f * 2.2F - f1 * 0.4F;
                this.leftArm.rotateAngleX += f * 2.2F - f1 * 0.4F;
            } else {
                this.rightArm.rotateAngleX = -1.4849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.leftArm.rotateAngleX = -1.4849558F + MathHelper.cos(ageInTicks * 0.09F) * 0.15F;
                this.rightArm.rotateAngleX += f * 2.2F - f1 * 0.4F;
                this.leftArm.rotateAngleX += f * 2.2F - f1 * 0.4F;
            }

            this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
            this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.09F) * 0.05F;
            this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.09F) * 0.05F;
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.SPELLCASTING) {
            this.rightArm.rotationPointZ = 0.0F;
            this.rightArm.rotationPointX = -5.0F;
            this.leftArm.rotationPointZ = 0.0F;
            this.leftArm.rotationPointX = 5.0F;
            this.rightArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.leftArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.rightArm.rotateAngleZ = 2.3561945F;
            this.leftArm.rotateAngleZ = -2.3561945F;
            this.rightArm.rotateAngleY = 0.0F;
            this.leftArm.rotateAngleY = 0.0F;
        } else if (abstractillager$illagerarmpose == AbstractIllager.IllagerArmPose.BOW_AND_ARROW) {
            this.rightArm.rotateAngleY = -0.1F + this.head.rotateAngleY;
            this.rightArm.rotateAngleX = -((float) Math.PI / 2F) + this.head.rotateAngleX;
            this.leftArm.rotateAngleX = -0.9424779F + this.head.rotateAngleX;
            this.leftArm.rotateAngleY = this.head.rotateAngleY - 0.4F;
            this.leftArm.rotateAngleZ = ((float) Math.PI / 2F);
        }
    }
}
