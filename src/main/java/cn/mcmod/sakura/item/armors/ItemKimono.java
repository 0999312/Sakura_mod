package cn.mcmod.sakura.item.armors;

import java.util.List;

import com.google.common.collect.Lists;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.api.kimono.KimonoLoader;
import cn.mcmod.sakura.client.model.ModelKimono;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import cn.mcmod_mmf.mmlib.util.TagPropertyAccessor.TagPropertyString;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKimono extends ItemArmor {
    public ItemKimono() {
        super(ItemLoader.KIMONO_MATERIAL, 0, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(SakuraMain.MODID + "." + "kimono");
    }
    
    public static final List<String> KimonoIDs = Lists.newArrayList();
    public static final TagPropertyString texture_name = new TagPropertyString("texture_name");
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
    	return getKimonoModel(entityLiving, itemStack, new ModelKimono());
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	NBTTagCompound nbt = RecipesUtil.getItemTagCompound(stack);
    	String name = texture_name.get(nbt,"kimono_base");
    	tooltip.add(I18n.format("sakura.kimono.texture.name")+":"+I18n.format("item.sakura."+name+".name"));
    	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
    	if(this.isInCreativeTab(tab)){
	        for(String name : KimonoIDs){
	            ItemStack kimono = KimonoLoader.getCustomKimono(name);
	            if(!kimono.isEmpty()) items.add(kimono);
	        }
    	}
    	super.getSubItems(tab, items);
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
    	NBTTagCompound nbt = RecipesUtil.getItemTagCompound(stack);
        String name = texture_name.get(nbt,"kimono_base");
    	return SakuraMain.MODID + ":" + "textures/models/armor/"+name+".png";
    }
    
    @SideOnly(Side.CLIENT)
    public static ModelBiped getKimonoModel(EntityLivingBase entityLiving, ItemStack itemStack,ModelBiped model)
    {
      if (model != null)
      {
        model.setVisible(true);
        
        model.isSneak = entityLiving.isSneaking();
        
        model.isRiding = entityLiving.isRiding();
        model.isChild = entityLiving.isChild();
        ItemStack itemstack = entityLiving.getHeldItemMainhand();
        ItemStack itemstack1 = entityLiving.getHeldItemOffhand();
        ModelBiped.ArmPose modelbiped$armpose = ModelBiped.ArmPose.EMPTY;
        ModelBiped.ArmPose modelbiped$armpose1 = ModelBiped.ArmPose.EMPTY;
        if ((itemstack != null) && (!itemstack.isEmpty()))
        {
          modelbiped$armpose = ModelBiped.ArmPose.ITEM;
          if (entityLiving.getItemInUseCount() > 0)
          {
            EnumAction enumaction = itemstack.getItemUseAction();
            if (enumaction == EnumAction.BLOCK) {
              modelbiped$armpose = ModelBiped.ArmPose.BLOCK;
            } else if (enumaction == EnumAction.BOW) {
              modelbiped$armpose = ModelBiped.ArmPose.BOW_AND_ARROW;
            }
          }
        }
        if ((itemstack1 != null) && (!itemstack1.isEmpty()))
        {
          modelbiped$armpose1 = ModelBiped.ArmPose.ITEM;
          if (entityLiving.getItemInUseCount() > 0)
          {
            EnumAction enumaction1 = itemstack1.getItemUseAction();
            if (enumaction1 == EnumAction.BLOCK) {
              modelbiped$armpose1 = ModelBiped.ArmPose.BLOCK;
            }
          }
        }
        if (entityLiving.getPrimaryHand() == EnumHandSide.RIGHT)
        {
          model.rightArmPose = modelbiped$armpose;
          model.leftArmPose = modelbiped$armpose1;
        }
        else
        {
          model.rightArmPose = modelbiped$armpose1;
          model.leftArmPose = modelbiped$armpose;
        }
      }
      return model;
    }

}
