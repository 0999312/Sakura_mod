package cn.mcmod.sakura.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelCustomArmor
  extends ModelBiped
{
  public ModelCustomArmor(float f, int i, int j, int k)
  {
    super(f, i, j, k);
  }
  
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
  {
    if ((entityIn instanceof EntityLivingBase)) {
      this.swingProgress = ((EntityLivingBase)entityIn).getSwingProgress(0F);
    }
    if ((entityIn instanceof EntityArmorStand))
    {
      setRotationAnglesStand(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }
    else if (((entityIn instanceof EntitySkeleton)) || ((entityIn instanceof EntityZombie)))
    {
      setRotationAnglesZombie(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }
    else
    {
      boolean flag = ((entityIn instanceof EntityLivingBase)) && (((EntityLivingBase)entityIn).getTicksElytraFlying() > 4);
      this.bipedHead.rotateAngleY = (netHeadYaw * 0.017453292F);
      if (flag) {
        this.bipedHead.rotateAngleX = -0.7853982F;
      } else {
        this.bipedHead.rotateAngleX = (headPitch * 0.017453292F);
      }
      this.bipedBody.rotateAngleY = 0.0F;
      this.bipedRightArm.rotationPointZ = 0.0F;
      this.bipedRightArm.rotationPointX = -5.0F;
      this.bipedLeftArm.rotationPointZ = 0.0F;
      this.bipedLeftArm.rotationPointX = 5.0F;
      float f = 1.0F;
      if (flag)
      {
        f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
        f /= 0.2F;
        f = f * f * f;
      }
      if (f < 1.0F) {
        f = 1.0F;
      }
      this.bipedRightArm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F / f);
      this.bipedLeftArm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f);
      this.bipedRightArm.rotateAngleZ = 0.0F;
      this.bipedLeftArm.rotateAngleZ = 0.0F;
      this.bipedRightLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f);
      this.bipedLeftLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / f);
      this.bipedRightLeg.rotateAngleY = 0.0F;
      this.bipedLeftLeg.rotateAngleY = 0.0F;
      this.bipedRightLeg.rotateAngleZ = 0.0F;
      this.bipedLeftLeg.rotateAngleZ = 0.0F;
      if (this.isRiding)
      {
        this.bipedRightArm.rotateAngleX += -0.62831855F;
        this.bipedLeftArm.rotateAngleX += -0.62831855F;
        this.bipedRightLeg.rotateAngleX = -1.4137167F;
        this.bipedRightLeg.rotateAngleY = 0.31415927F;
        this.bipedRightLeg.rotateAngleZ = 0.07853982F;
        this.bipedLeftLeg.rotateAngleX = -1.4137167F;
        this.bipedLeftLeg.rotateAngleY = -0.31415927F;
        this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
      }
      this.bipedRightArm.rotateAngleY = 0.0F;
      this.bipedRightArm.rotateAngleZ = 0.0F;
      switch (this.leftArmPose)
      {
      case EMPTY: 
        this.bipedLeftArm.rotateAngleY = 0.0F;
        break;
      case BLOCK: 
        this.bipedLeftArm.rotateAngleX = (this.bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F);
        this.bipedLeftArm.rotateAngleY = 0.5235988F;
        break;
      case ITEM: 
        this.bipedLeftArm.rotateAngleX = (this.bipedLeftArm.rotateAngleX * 0.5F - 0.31415927F);
        this.bipedLeftArm.rotateAngleY = 0.0F;
	case BOW_AND_ARROW:
		break;
	default:
		break;
      }
      switch (this.rightArmPose)
      {
      case EMPTY: 
        this.bipedRightArm.rotateAngleY = 0.0F;
        break;
      case BLOCK: 
        this.bipedRightArm.rotateAngleX = (this.bipedRightArm.rotateAngleX * 0.5F - 0.9424779F);
        this.bipedRightArm.rotateAngleY = -0.5235988F;
        break;
      case ITEM: 
        this.bipedRightArm.rotateAngleX = (this.bipedRightArm.rotateAngleX * 0.5F - 0.31415927F);
        this.bipedRightArm.rotateAngleY = 0.0F;
	default:
		break;
      }
      if (this.swingProgress > 0.0F)
      {
        EnumHandSide enumhandside = getMainHand(entityIn);
        ModelRenderer modelrenderer = getArmForSide(enumhandside);
        float f1 = this.swingProgress;
        this.bipedBody.rotateAngleY = (MathHelper.sin(MathHelper.sqrt(f1) * 6.2831855F) * 0.2F);
        if (enumhandside == EnumHandSide.LEFT) {
          this.bipedBody.rotateAngleY *= -1.0F;
        }
        this.bipedRightArm.rotationPointZ = (MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F);
        this.bipedRightArm.rotationPointX = (-MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F);
        this.bipedLeftArm.rotationPointZ = (-MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F);
        this.bipedLeftArm.rotationPointX = (MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F);
        this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
        this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
        this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
        f1 = 1.0F - this.swingProgress;
        f1 *= f1;
        f1 *= f1;
        f1 = 1.0F - f1;
        float f2 = MathHelper.sin(f1 * 3.1415927F);
        float f3 = MathHelper.sin(this.swingProgress * 3.1415927F) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
        modelrenderer.rotateAngleX = ((float)(modelrenderer.rotateAngleX - (f2 * 1.2D + f3)));
        modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
        modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * 3.1415927F) * -0.4F;
      }
      if (this.isSneak)
      {
        this.bipedBody.rotateAngleX = 0.5F;
        this.bipedRightArm.rotateAngleX += 0.4F;
        this.bipedLeftArm.rotateAngleX += 0.4F;
        this.bipedRightLeg.rotationPointZ = 4.0F;
        this.bipedLeftLeg.rotationPointZ = 4.0F;
        this.bipedRightLeg.rotationPointY = 13.0F;
        this.bipedLeftLeg.rotationPointY = 13.0F;
        this.bipedHead.rotationPointY = 4.5F;
        
        this.bipedBody.rotationPointY = 4.5F;
        this.bipedRightArm.rotationPointY = 5.0F;
        this.bipedLeftArm.rotationPointY = 5.0F;
      }
      else
      {
        this.bipedBody.rotateAngleX = 0.0F;
        this.bipedRightLeg.rotationPointZ = 0.1F;
        this.bipedLeftLeg.rotationPointZ = 0.1F;
        this.bipedRightLeg.rotationPointY = 12.0F;
        this.bipedLeftLeg.rotationPointY = 12.0F;
        this.bipedHead.rotationPointY = 0.0F;
        
        this.bipedBody.rotationPointY = 0.0F;
        this.bipedRightArm.rotationPointY = 2.0F;
        this.bipedLeftArm.rotationPointY = 2.0F;
      }
      this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
      this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
      this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
      this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
      if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
      {
        this.bipedRightArm.rotateAngleY = (-0.1F + this.bipedHead.rotateAngleY);
        this.bipedLeftArm.rotateAngleY = (0.1F + this.bipedHead.rotateAngleY + 0.4F);
        this.bipedRightArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
        this.bipedLeftArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
      }
      else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
      {
        this.bipedRightArm.rotateAngleY = (-0.1F + this.bipedHead.rotateAngleY - 0.4F);
        this.bipedLeftArm.rotateAngleY = (0.1F + this.bipedHead.rotateAngleY);
        this.bipedRightArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
        this.bipedLeftArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
      }
      copyModelAngles(this.bipedHead, this.bipedHeadwear);
    }
  }
  
  public void setRotationAnglesZombie(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
  {
    super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    
    boolean flag = ((entityIn instanceof EntityZombie)) && (((EntityZombie)entityIn).isArmsRaised());
    float f = MathHelper.sin(this.swingProgress * 3.1415927F);
    float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * 3.1415927F);
    this.bipedRightArm.rotateAngleZ = 0.0F;
    this.bipedLeftArm.rotateAngleZ = 0.0F;
    this.bipedRightArm.rotateAngleY = (-(0.1F - f * 0.6F));
    this.bipedLeftArm.rotateAngleY = (0.1F - f * 0.6F);
    float f2 = -3.1415927F / (flag ? 1.5F : 2.25F);
    this.bipedRightArm.rotateAngleX = f2;
    this.bipedLeftArm.rotateAngleX = f2;
    this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
    this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
    this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
    this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
    this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
    this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
  }
  
  public void setRotationAnglesStand(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
  {
    if ((entityIn instanceof EntityArmorStand))
    {
      EntityArmorStand entityarmorstand = (EntityArmorStand)entityIn;
      this.bipedHead.rotateAngleX = (0.017453292F * entityarmorstand.getHeadRotation().getX());
      this.bipedHead.rotateAngleY = (0.017453292F * entityarmorstand.getHeadRotation().getY());
      this.bipedHead.rotateAngleZ = (0.017453292F * entityarmorstand.getHeadRotation().getZ());
      this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
      this.bipedBody.rotateAngleX = (0.017453292F * entityarmorstand.getBodyRotation().getX());
      this.bipedBody.rotateAngleY = (0.017453292F * entityarmorstand.getBodyRotation().getY());
      this.bipedBody.rotateAngleZ = (0.017453292F * entityarmorstand.getBodyRotation().getZ());
      this.bipedLeftArm.rotateAngleX = (0.017453292F * entityarmorstand.getLeftArmRotation().getX());
      this.bipedLeftArm.rotateAngleY = (0.017453292F * entityarmorstand.getLeftArmRotation().getY());
      this.bipedLeftArm.rotateAngleZ = (0.017453292F * entityarmorstand.getLeftArmRotation().getZ());
      this.bipedRightArm.rotateAngleX = (0.017453292F * entityarmorstand.getRightArmRotation().getX());
      this.bipedRightArm.rotateAngleY = (0.017453292F * entityarmorstand.getRightArmRotation().getY());
      this.bipedRightArm.rotateAngleZ = (0.017453292F * entityarmorstand.getRightArmRotation().getZ());
      this.bipedLeftLeg.rotateAngleX = (0.017453292F * entityarmorstand.getLeftLegRotation().getX());
      this.bipedLeftLeg.rotateAngleY = (0.017453292F * entityarmorstand.getLeftLegRotation().getY());
      this.bipedLeftLeg.rotateAngleZ = (0.017453292F * entityarmorstand.getLeftLegRotation().getZ());
      this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
      this.bipedRightLeg.rotateAngleX = (0.017453292F * entityarmorstand.getRightLegRotation().getX());
      this.bipedRightLeg.rotateAngleY = (0.017453292F * entityarmorstand.getRightLegRotation().getY());
      this.bipedRightLeg.rotateAngleZ = (0.017453292F * entityarmorstand.getRightLegRotation().getZ());
      this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
      copyModelAngles(this.bipedHead, this.bipedHeadwear);
    }
  }
}
