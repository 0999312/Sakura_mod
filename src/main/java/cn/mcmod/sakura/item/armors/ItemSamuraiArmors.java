package cn.mcmod.sakura.item.armors;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.ModelSamuraiArmors;
import cn.mcmod_mmf.mmlib.util.ClientUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSamuraiArmors extends ItemArmor {

	public ItemSamuraiArmors(String name,ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	    setUnlocalizedName(SakuraMain.MODID+"."+name);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		return SakuraMain.MODID + ":" + "textures/models/armor/samurai_armor.png";
	}
	
	  ModelBiped model1 = null;
	  ModelBiped model2 = null;
	  ModelBiped model = null;
	  
	  @SideOnly(Side.CLIENT)
	  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
	  {
	    if (this.model1 == null) {
	      this.model1 = new ModelSamuraiArmors(armorSlot,3,1.0F);
	    }
	    if (this.model2 == null) {
	      this.model2 = new ModelSamuraiArmors(armorSlot,3,0.5F);
	    }
	    
	    this.model = ClientUtils.getInstance().getCustomArmorModel(entityLiving, itemStack, armorSlot, this.model, this.model1, this.model2);
	    return this.model;
	  }
}
