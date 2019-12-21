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

import org.lwjgl.opengl.GL11;

import cn.mcmod.sakura.util.ClientUtils;

public class ModelHaori extends ModelCustomArmor
{
	ModelRenderer body;
	ModelRenderer rightArm;
	ModelRenderer leftArm;

	public ModelHaori() {
	    super(1.3F, 0, 64, 64);
	    this.textureWidth = 64;
	    this.textureHeight = 16;
	    
	    body = new ModelRenderer(this, 0, 0);
		body.addBox(-3.5F, 0F, -1.5F, 7, 12, 3,1.3f);
		body.setTextureSize(64, 16);
		body.setRotationPoint(0F, 0F, 0F);
		setRotation(body, 0, 0, 0);
		rightArm = new ModelRenderer(this, 24, 0);
		rightArm.addBox(-2.5F, -2F, -1.5F, 3, 12, 3,1.25F);
		rightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightArm.setTextureSize(64, 16);
		setRotation(rightArm, 0, 0, 0);
		leftArm = new ModelRenderer(this, 40, 0);
		leftArm.addBox(-0.5F, -2F, -1.5F, 3, 12, 3,1.25F);
		leftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftArm.setTextureSize(64, 16);
		setRotation(leftArm, 0, 0, 0);
		
		this.bipedHeadwear.cubeList.clear();
	    this.bipedHead.cubeList.clear();
	    this.bipedBody.cubeList.clear();
	    this.bipedBody.addChild(this.body);
	    
	    this.bipedRightArm.cubeList.clear();
	    this.bipedLeftArm.cubeList.clear();
	    
	    this.bipedRightLeg.cubeList.clear();

	    this.bipedLeftLeg.cubeList.clear();
	}
  
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5){

	    this.rightArm.isHidden = false;
	    this.leftArm.isHidden = false;
	    this.body.isHidden = false;
	    
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    if (this.isChild)
	    {
	      float f6 = 2.0F;
	      GL11.glPushMatrix();
	      GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
	      GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
	      this.bipedHead.render(f5);
	      GL11.glPopMatrix();
	      GL11.glPushMatrix();
	      GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	      GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
	      this.bipedBody.render(f5);
	      this.rightArm.render(f5);
	      this.leftArm.render(f5);
	      this.bipedRightLeg.render(f5);
	      this.bipedLeftLeg.render(f5);
	      this.bipedHeadwear.render(f5);
	      
	      GL11.glPopMatrix();
	    }
	    else
	    {
	      GL11.glPushMatrix();
	      GL11.glScalef(1.01F, 1.01F, 1.01F);
	      this.bipedHead.render(f5);
	      GL11.glPopMatrix();
	      this.bipedBody.render(f5);
	      this.rightArm.render(f5);
	      this.leftArm.render(f5);
	      this.bipedRightLeg.render(f5);
	      this.bipedLeftLeg.render(f5);
	      this.bipedHeadwear.render(f5);
	    }
	  }
	  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
  {
    if ((entityIn instanceof EntityLivingBase)) {
      this.swingProgress = ((EntityLivingBase)entityIn).getSwingProgress(ClientUtils.sysPartialTicks);
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
      this.rightArm.rotationPointZ = 0.0F;
      this.rightArm.rotationPointX = -5.0F;
      this.leftArm.rotationPointZ = 0.0F;
      this.leftArm.rotationPointX = 5.0F;
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
      this.rightArm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F / f);
      this.leftArm.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f);
      this.rightArm.rotateAngleZ = 0.0F;
      this.leftArm.rotateAngleZ = 0.0F;
      this.bipedRightLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f);
      this.bipedLeftLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / f);
      this.bipedRightLeg.rotateAngleY = 0.0F;
      this.bipedLeftLeg.rotateAngleY = 0.0F;
      this.bipedRightLeg.rotateAngleZ = 0.0F;
      this.bipedLeftLeg.rotateAngleZ = 0.0F;
      if (this.isRiding)
      {
        this.rightArm.rotateAngleX += -0.62831855F;
        this.leftArm.rotateAngleX += -0.62831855F;
        this.bipedRightLeg.rotateAngleX = -1.4137167F;
        this.bipedRightLeg.rotateAngleY = 0.31415927F;
        this.bipedRightLeg.rotateAngleZ = 0.07853982F;
        this.bipedLeftLeg.rotateAngleX = -1.4137167F;
        this.bipedLeftLeg.rotateAngleY = -0.31415927F;
        this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
      }
      this.rightArm.rotateAngleY = 0.0F;
      this.rightArm.rotateAngleZ = 0.0F;
      switch (this.leftArmPose)
      {
      case EMPTY: 
        this.leftArm.rotateAngleY = 0.0F;
        break;
      case BLOCK: 
        this.leftArm.rotateAngleX = (this.leftArm.rotateAngleX * 0.5F - 0.9424779F);
        this.leftArm.rotateAngleY = 0.5235988F;
        break;
      case ITEM: 
        this.leftArm.rotateAngleX = (this.leftArm.rotateAngleX * 0.5F - 0.31415927F);
        this.leftArm.rotateAngleY = 0.0F;
	case BOW_AND_ARROW:
		break;
	default:
		break;
      }
      switch (this.rightArmPose)
      {
      case EMPTY: 
        this.rightArm.rotateAngleY = 0.0F;
        break;
      case BLOCK: 
        this.rightArm.rotateAngleX = (this.rightArm.rotateAngleX * 0.5F - 0.9424779F);
        this.rightArm.rotateAngleY = -0.5235988F;
        break;
      case ITEM: 
        this.rightArm.rotateAngleX = (this.rightArm.rotateAngleX * 0.5F - 0.31415927F);
        this.rightArm.rotateAngleY = 0.0F;
	default:
		break;
      }
      if (this.swingProgress > 0.0F)
      {
        EnumHandSide enumhandside = getMainHand(entityIn);
        ModelRenderer modelrenderer = enumhandside == EnumHandSide.LEFT ? this.leftArm : this.rightArm;
        float f1 = this.swingProgress;
        this.bipedBody.rotateAngleY = (MathHelper.sin(MathHelper.sqrt(f1) * 6.2831855F) * 0.2F);
        if (enumhandside == EnumHandSide.LEFT) {
          this.bipedBody.rotateAngleY *= -1.0F;
        }
        this.rightArm.rotationPointZ = (MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F);
        this.rightArm.rotationPointX = (-MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F);
        this.leftArm.rotationPointZ = (-MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F);
        this.leftArm.rotationPointX = (MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F);
        this.rightArm.rotateAngleY += this.bipedBody.rotateAngleY;
        this.leftArm.rotateAngleY += this.bipedBody.rotateAngleY;
        this.leftArm.rotateAngleX += this.bipedBody.rotateAngleY;
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
        this.rightArm.rotateAngleX += 0.4F;
        this.leftArm.rotateAngleX += 0.4F;
        this.bipedRightLeg.rotationPointZ = 4.0F;
        this.bipedLeftLeg.rotationPointZ = 4.0F;
        this.bipedRightLeg.rotationPointY = 13.0F;
        this.bipedLeftLeg.rotationPointY = 13.0F;
        this.bipedHead.rotationPointY = 4.5F;
        
        this.bipedBody.rotationPointY = 4.0F;
        this.rightArm.rotationPointY = 5.0F;
        this.leftArm.rotationPointY = 5.0F;
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
        this.rightArm.rotationPointY = 2.0F;
        this.leftArm.rotationPointY = 2.0F;
      }
      this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
      this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
      this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
      this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
      if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
      {
        this.rightArm.rotateAngleY = (-0.1F + this.bipedHead.rotateAngleY);
        this.leftArm.rotateAngleY = (0.1F + this.bipedHead.rotateAngleY + 0.4F);
        this.rightArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
        this.leftArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
      }
      else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
      {
        this.rightArm.rotateAngleY = (-0.1F + this.bipedHead.rotateAngleY - 0.4F);
        this.leftArm.rotateAngleY = (0.1F + this.bipedHead.rotateAngleY);
        this.rightArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
        this.leftArm.rotateAngleX = (-1.5707964F + this.bipedHead.rotateAngleX);
      }
      copyModelAngles(this.bipedHead, this.bipedHeadwear);
    }
  }
  
}
