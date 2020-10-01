package cn.mcmod.sakura.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.lwjgl.opengl.GL11;

public class ModelSamuraiArmors2
  extends ModelCustomArmor
{
  ModelRenderer Helmet;
  ModelRenderer HelmetR;
  ModelRenderer HelmetL;
  ModelRenderer HelmetB;
  ModelRenderer capsthingy;
  ModelRenderer BeltR;
  ModelRenderer Mbelt;
  ModelRenderer MbeltL;
  ModelRenderer MbeltR;
  ModelRenderer BeltL;
  ModelRenderer Chestplate;
  ModelRenderer Backplate;
  ModelRenderer ShoulderR;
  ModelRenderer GauntletR;
  ModelRenderer GauntletstrapR;
  ModelRenderer ShoulderplateRtop;
  ModelRenderer ShoulderplateR1;
  ModelRenderer ShoulderL;
  ModelRenderer GauntletL;
  ModelRenderer GauntletstrapL;
  ModelRenderer ShoulderplateLtop;
  ModelRenderer ShoulderplateL1;
  ModelRenderer LegpanelR4;
  ModelRenderer LegpanelR5;
//  ModelRenderer LegpanelR6;
  ModelRenderer SidepanelR1;
  ModelRenderer SidepanelR2;
//  ModelRenderer SidepanelR3;
  ModelRenderer BackpanelR1;
  ModelRenderer BackpanelR2;
//  ModelRenderer BackpanelR3;
//  ModelRenderer BackpanelL3;

  ModelRenderer LegpanelL4;
  ModelRenderer LegpanelL5;
//  ModelRenderer LegpanelL6;
  ModelRenderer SidepanelL1;
  ModelRenderer SidepanelL2;
//  ModelRenderer SidepanelL3;
  ModelRenderer BackpanelL1;
  ModelRenderer BackpanelL2;
  ModelRenderer ShoesL;
  ModelRenderer ShoesR;
  ModelRenderer ShoesPartL;
  ModelRenderer ShoesPartR;
  public int state = 0;
  public EntityEquipmentSlot armorSlot = EntityEquipmentSlot.CHEST;
  public ModelSamuraiArmors2(EntityEquipmentSlot slot,int armor_state,float f)
  {
    super(f, 0, 128, 64);
    this.textureWidth = 128;
    this.textureHeight = 64;
    this.state = armor_state;
    this.armorSlot=slot;
    
    this.Helmet = new ModelRenderer(this, 41, 8);
    this.Helmet.addBox(-4.5F, -9.0F, -4.5F, 9, 4, 9);
    this.Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Helmet.setTextureSize(128, 64);
    setRotation(this.Helmet, 0.0F, 0.0F, 0.0F);
    
    this.HelmetR = new ModelRenderer(this, 21, 13);
    this.HelmetR.addBox(-5.5F, -5.0F, -4.5F, 1, 5, 9);
    this.HelmetR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.HelmetR.setTextureSize(128, 64);
    setRotation(this.HelmetR, 0.0F, 0.0F, 0.15235988F);
    this.HelmetL = new ModelRenderer(this, 21, 13);
    this.HelmetL.mirror = true;
    this.HelmetL.addBox(4.50F, -5.0F, -4.5F, 1, 5, 9);
    this.HelmetL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.HelmetL.setTextureSize(128, 64);
    setRotation(this.HelmetL, 0.0F, 0.0F, -0.15235988F);
    
    this.HelmetB = new ModelRenderer(this, 41, 21);
    this.HelmetB.addBox(-4.5F, -3.0F, 5.5F, 9, 5, 1);
    this.HelmetB.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.HelmetB.setTextureSize(128, 64);
    setRotation(this.HelmetB, 0.5235988F, 0.0F, 0.0F);
    this.capsthingy = new ModelRenderer(this, 21, 0);
    this.capsthingy.addBox(-4.5F, -6.0F, -6.5F, 9, 1, 2);
    this.capsthingy.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.capsthingy.setTextureSize(128, 64);
    setRotation(this.capsthingy, 0.0F, 0.0F, 0.0F);
    this.BeltR = new ModelRenderer(this, 76, 44);
    this.BeltR.addBox(-5.0F, 4.0F, -3.0F, 1, 3, 6);
    this.BeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BeltR.setTextureSize(128, 64);
    setRotation(this.BeltR, 0.0F, 0.0F, 0.0F);
    this.Mbelt = new ModelRenderer(this, 56, 55);
    this.Mbelt.addBox(-4.0F, 8.0F, -3.0F, 8, 4, 1);
    this.Mbelt.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Mbelt.setTextureSize(128, 64);
    setRotation(this.Mbelt, 0.0F, 0.0F, 0.0F);
    this.MbeltL = new ModelRenderer(this, 76, 44);
    this.MbeltL.addBox(4.0F, 8.0F, -3.0F, 1, 3, 6);
    this.MbeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.MbeltL.setTextureSize(128, 64);
    setRotation(this.MbeltL, 0.0F, 0.0F, 0.0F);
    this.MbeltR = new ModelRenderer(this, 76, 44);
    this.MbeltR.addBox(-5.0F, 8.0F, -3.0F, 1, 3, 6);
    this.MbeltR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.MbeltR.setTextureSize(128, 64);
    setRotation(this.MbeltR, 0.0F, 0.0F, 0.0F);
    
    this.ShoesL = new ModelRenderer(this, 84, 4);
    this.ShoesL.addBox(-2.0F, 5F, -2.0F, 4, 4, 4,f+0.0005f);
    this.ShoesL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoesL.setTextureSize(128, 64);
    setRotation(this.ShoesL, 0.0F, 0.0F, 0.0F);
    this.ShoesR = new ModelRenderer(this, 84, 4);
    this.ShoesR.addBox(-2.0F, 5F, -2.0F, 4, 4, 4,f+0.0005f);
    this.ShoesR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoesR.setTextureSize(128, 64);
    setRotation(this.ShoesR, 0.0F, 0.0F, 0.0F);
    
    this.ShoesPartL = new ModelRenderer(this, 100, 4);
    this.ShoesPartL.addBox(-2.5F, 10.5F, -3.6F, 5, 2, 6);
    this.ShoesPartL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoesPartL.setTextureSize(128, 64);
    setRotation(this.ShoesPartL, 0.0F, 0.0F, 0.0F);
    this.ShoesPartR = new ModelRenderer(this, 100, 4);
    this.ShoesPartR.addBox(-2.5F, 10.5F, -3.6F, 5, 2, 6);
    this.ShoesPartR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoesPartR.setTextureSize(128, 64);
    setRotation(this.ShoesPartR, 0.0F, 0.0F, 0.0F);
    
    this.BeltL = new ModelRenderer(this, 76, 44);
    this.BeltL.addBox(4.0F, 4.0F, -3.0F, 1, 3, 6);
    this.BeltL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BeltL.setTextureSize(128, 64);
    setRotation(this.BeltL, 0.0F, 0.0F, 0.0F);
    this.Chestplate = new ModelRenderer(this, 56, 45);
    this.Chestplate.addBox(-4.0F, 1.0F, -4.0F, 8, 7, 2);
    this.Chestplate.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Chestplate.setTextureSize(128, 64);
    setRotation(this.Chestplate, 0.0F, 0.0F, 0.0F);

    this.Backplate = new ModelRenderer(this, 36, 45);
    this.Backplate.addBox(-4.0F, 1.0F, 2.0F, 8, 11, 2);
    this.Backplate.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Backplate.setTextureSize(128, 64);
    setRotation(this.Backplate, 0.0F, 0.0F, 0.0F);

    this.ShoulderR = new ModelRenderer(this, 56, 35);
    this.ShoulderR.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
    this.ShoulderR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoulderR.setTextureSize(128, 64);
    setRotation(this.ShoulderR, 0.0F, 0.0F, 0.0F);
    this.GauntletR = new ModelRenderer(this, 100, 26);
    this.GauntletR.addBox(-3.5F, 4F, -2.5F, 2, 5, 5);
    this.GauntletR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.GauntletR.setTextureSize(128, 64);
    setRotation(this.GauntletR, 0.0F, 0.0F, 0.0F);
    this.GauntletstrapR = new ModelRenderer(this, 84, 31);
    this.GauntletstrapR.addBox(-1.5F, 2.5F, -2.5F, 3, 7, 5);
    this.GauntletstrapR.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.GauntletstrapR.setTextureSize(128, 64);
    setRotation(this.GauntletstrapR, 0.0F, 0.0F, 0.0F);
    this.ShoulderplateRtop = new ModelRenderer(this, 110, 37);
    this.ShoulderplateRtop.addBox(-5.5F, -2.5F, -3.5F, 2, 1, 7);
    this.ShoulderplateRtop.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoulderplateRtop.setTextureSize(128, 64);
    setRotation(this.ShoulderplateRtop, 0.0F, 0.0F, 0.4363323F);
    this.ShoulderplateR1 = new ModelRenderer(this, 110, 45);
    this.ShoulderplateR1.addBox(-4.5F, -1.5F, -3.5F, 1, 4, 7);
    this.ShoulderplateR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoulderplateR1.setTextureSize(128, 64);
    setRotation(this.ShoulderplateR1, 0.0F, 0.0F, 0.4363323F);
    
    this.ShoulderL = new ModelRenderer(this, 56, 35);
    this.ShoulderL.mirror = true;
    this.ShoulderL.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
    this.ShoulderL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoulderL.setTextureSize(128, 64);
    setRotation(this.ShoulderL, 0.0F, 0.0F, 0.0F);
    
    this.GauntletL = new ModelRenderer(this, 114, 26);
    this.GauntletL.addBox(1.5F, 4F, -2.5F, 2, 5, 5);
    this.GauntletL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.GauntletL.setTextureSize(128, 64);
    setRotation(this.GauntletL, 0.0F, 0.0F, 0.0F);
    
    this.GauntletstrapL = new ModelRenderer(this, 84, 31);
    this.GauntletstrapL.mirror = true;
    this.GauntletstrapL.addBox(-1.5F, 2.5F, -2.5F, 3, 7, 5);
    this.GauntletstrapL.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.GauntletstrapL.setTextureSize(128, 64);
    setRotation(this.GauntletstrapL, 0.0F, 0.0F, 0.0F);
    
    this.ShoulderplateLtop = new ModelRenderer(this, 110, 37);
    this.ShoulderplateLtop.mirror = true;
    this.ShoulderplateLtop.addBox(3.5F, -2.5F, -3.5F, 2, 1, 7);
    this.ShoulderplateLtop.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoulderplateLtop.setTextureSize(128, 64);
    setRotation(this.ShoulderplateLtop, 0.0F, 0.0F, -0.4363323F);
    
    this.ShoulderplateL1 = new ModelRenderer(this, 110, 45);
    this.ShoulderplateL1.mirror = true;
    this.ShoulderplateL1.addBox(3.5F, -1.5F, -3.5F, 1, 4, 7);
    this.ShoulderplateL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.ShoulderplateL1.setTextureSize(128, 64);
    setRotation(this.ShoulderplateL1, 0.0F, 0.0F, -0.4363323F);
    
    this.LegpanelR4 = new ModelRenderer(this, 0, 18);
    this.LegpanelR4.addBox(-3.0F, 0.5F, -3.5F, 5, 3, 1);
    this.LegpanelR4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.LegpanelR4.setTextureSize(128, 64);
    setRotation(this.LegpanelR4, -0.4363323F, 0.0F, 0.0F);
    
    this.LegpanelR5 = new ModelRenderer(this, 0, 18);
    this.LegpanelR5.addBox(-3.0F, 2.5F, -2.5F, 5, 3, 1);
    this.LegpanelR5.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.LegpanelR5.setTextureSize(128, 64);
    setRotation(this.LegpanelR5, -0.4363323F, 0.0F, 0.0F);

    this.SidepanelR1 = new ModelRenderer(this, 0, 22);
    this.SidepanelR1.addBox(-2.5F, 0.5F, -2.5F, 1, 4, 5);
    this.SidepanelR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.SidepanelR1.setTextureSize(128, 64);
    setRotation(this.SidepanelR1, 0.0F, 0.0F, 0.4363323F);
    
    this.SidepanelR2 = new ModelRenderer(this, 0, 31);
    this.SidepanelR2.addBox(-1.5F, 3.5F, -2.5F, 1, 3, 5);
    this.SidepanelR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.SidepanelR2.setTextureSize(128, 64);
    setRotation(this.SidepanelR2, 0.0F, 0.0F, 0.4363323F);

    this.BackpanelR1 = new ModelRenderer(this, 0, 18);
    this.BackpanelR1.addBox(-3.0F, 0.5F, 2.5F, 5, 3, 1);
    this.BackpanelR1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelR1.setTextureSize(128, 64);
    setRotation(this.BackpanelR1, 0.4363323F, 0.0F, 0.0F);
    
    this.BackpanelR2 = new ModelRenderer(this, 0, 18);
    this.BackpanelR2.addBox(-3.0F, 2.5F, 1.5F, 5, 3, 1);
    this.BackpanelR2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelR2.setTextureSize(128, 64);
    setRotation(this.BackpanelR2, 0.4363323F, 0.0F, 0.0F);

    this.LegpanelL4 = new ModelRenderer(this, 0, 18);
    this.LegpanelL4.mirror = true;
    this.LegpanelL4.addBox(-2F, 0.5F, -3.5F, 5, 3, 1);
    this.LegpanelL4.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.LegpanelL4.setTextureSize(128, 64);
    setRotation(this.LegpanelL4, -0.4363323F, 0.0F, 0.0F);
    
    this.LegpanelL5 = new ModelRenderer(this, 0, 18);
    this.LegpanelL5.mirror = true;
    this.LegpanelL5.addBox(-2.0F, 2.5F, -2.5F, 5, 3, 1);
    this.LegpanelL5.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.LegpanelL5.setTextureSize(128, 64);
    setRotation(this.LegpanelL5, -0.4363323F, 0.0F, 0.0F);

    this.SidepanelL1 = new ModelRenderer(this, 0, 22);
    this.SidepanelL1.mirror = true;
    this.SidepanelL1.addBox(1.5F, 0.5F, -2.5F, 1, 4, 5);
    this.SidepanelL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.SidepanelL1.setTextureSize(128, 64);
    setRotation(this.SidepanelL1, 0.0F, 0.0F, -0.4363323F);
    
    this.SidepanelL2 = new ModelRenderer(this, 0, 31);
    this.SidepanelL2.mirror = true;
    this.SidepanelL2.addBox(0.5F, 3.5F, -2.5F, 1, 3, 5);
    this.SidepanelL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.SidepanelL2.setTextureSize(128, 64);
    setRotation(this.SidepanelL2, 0.0F, 0.0F, -0.4363323F);

    this.BackpanelL1 = new ModelRenderer(this, 0, 18);
    this.BackpanelL1.mirror = true;
    this.BackpanelL1.addBox(-2.0F, 0.5F, 2.5F, 5, 3, 1);
    this.BackpanelL1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelL1.setTextureSize(128, 64);
    setRotation(this.BackpanelL1, 0.4363323F, 0.0F, 0.0F);
    
    this.BackpanelL2 = new ModelRenderer(this, 0, 18);
    this.BackpanelL2.mirror = true;
    this.BackpanelL2.addBox(-2.0F, 2.5F, 1.5F, 5, 3, 1);
    this.BackpanelL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.BackpanelL2.setTextureSize(128, 64);
    setRotation(this.BackpanelL2, 0.4363323F, 0.0F, 0.0F);
    
    this.bipedHeadwear.cubeList.clear();
    this.bipedHead.cubeList.clear();
    this.bipedHead.addChild(this.Helmet);
    this.bipedHead.addChild(this.HelmetR);
    this.bipedHead.addChild(this.HelmetL);
    this.bipedHead.addChild(this.HelmetB);
    this.bipedHead.addChild(this.capsthingy);
    
    this.bipedBody.cubeList.clear();
    if (f < 1.0F)
    {
      this.bipedBody.addChild(this.Mbelt);
      this.bipedBody.addChild(this.MbeltL);
      this.bipedBody.addChild(this.MbeltR);
    }
    else
    {
      this.bipedBody.addChild(this.BeltR);
      this.bipedBody.addChild(this.BeltL);
      this.bipedBody.addChild(this.Chestplate);
      this.bipedBody.addChild(this.Backplate);
    }
    this.bipedRightArm.cubeList.clear();
    this.bipedRightArm.addChild(this.ShoulderR);
    this.bipedRightArm.addChild(this.GauntletR);
    this.bipedRightArm.addChild(this.GauntletstrapR);
    this.bipedRightArm.addChild(this.ShoulderplateRtop);
    this.bipedRightArm.addChild(this.ShoulderplateR1);
    
    this.bipedLeftArm.cubeList.clear();
    this.bipedLeftArm.addChild(this.ShoulderL);
    this.bipedLeftArm.addChild(this.GauntletL);
    this.bipedLeftArm.addChild(this.GauntletstrapL);
    this.bipedLeftArm.addChild(this.ShoulderplateLtop);
    this.bipedLeftArm.addChild(this.ShoulderplateL1);
    
    this.bipedRightLeg.cubeList.clear();
    this.bipedRightLeg.addChild(this.LegpanelR4);
    this.bipedRightLeg.addChild(this.LegpanelR5);
    this.bipedRightLeg.addChild(this.SidepanelR1);
    this.bipedRightLeg.addChild(this.SidepanelR2);
    this.bipedRightLeg.addChild(this.BackpanelR1);
    this.bipedRightLeg.addChild(this.BackpanelR2);
    this.bipedRightLeg.addChild(this.ShoesR);
    this.bipedRightLeg.addChild(this.ShoesPartR);
    
    this.bipedLeftLeg.cubeList.clear();

    this.bipedLeftLeg.addChild(this.LegpanelL4);
    this.bipedLeftLeg.addChild(this.LegpanelL5);
    this.bipedLeftLeg.addChild(this.SidepanelL1);
    this.bipedLeftLeg.addChild(this.SidepanelL2);
    this.bipedLeftLeg.addChild(this.BackpanelL1);
    this.bipedLeftLeg.addChild(this.BackpanelL2);
    this.bipedLeftLeg.addChild(this.ShoesL);
    this.bipedLeftLeg.addChild(this.ShoesPartL);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {

    this.LegpanelL4.isHidden = (state < 1)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.LegpanelL5.isHidden = (state < 2)||(armorSlot!=EntityEquipmentSlot.LEGS);
    
    this.Chestplate.isHidden = false;
    
    this.LegpanelR4.isHidden = (state < 1)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.LegpanelR5.isHidden = (state < 2)||(armorSlot!=EntityEquipmentSlot.LEGS);
    
    this.BackpanelL1.isHidden = (state < 1)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.BackpanelL2.isHidden = (state < 2)||(armorSlot!=EntityEquipmentSlot.LEGS);
    
    this.BackpanelR1.isHidden = (state < 1)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.BackpanelR2.isHidden = (state < 2)||(armorSlot!=EntityEquipmentSlot.LEGS);
    
    this.SidepanelR1.isHidden = (state < 1)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.SidepanelL1.isHidden = (state < 1)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.SidepanelR2.isHidden = (state < 2)||(armorSlot!=EntityEquipmentSlot.LEGS);
    this.SidepanelL2.isHidden = (state < 2)||(armorSlot!=EntityEquipmentSlot.LEGS);
    
    this.ShoesL.isHidden=(armorSlot!=EntityEquipmentSlot.FEET);
    this.ShoesR.isHidden=(armorSlot!=EntityEquipmentSlot.FEET);
    this.ShoesPartL.isHidden=(armorSlot!=EntityEquipmentSlot.FEET);
    this.ShoesPartR.isHidden=(armorSlot!=EntityEquipmentSlot.FEET);
    
    this.ShoulderplateLtop.isHidden = (state < 2);
    this.ShoulderplateL1.isHidden = (state < 2);
    this.ShoulderplateRtop.isHidden = (state < 2);
    this.ShoulderplateR1.isHidden = (state < 2);

    this.BeltL.isHidden = true;
    this.BeltR.isHidden = true;
    
    this.GauntletL.isHidden = (state < 2);
    this.GauntletR.isHidden = (state < 2);
    this.GauntletstrapL.isHidden = (state < 2);
    this.GauntletstrapR.isHidden = (state < 2);
    

    
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
      this.bipedRightArm.render(f5);
      this.bipedLeftArm.render(f5);
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
      this.bipedRightArm.render(f5);
      this.bipedLeftArm.render(f5);
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
}
