package cn.mcmod.sakura.item.armors;

import java.util.List;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.ModelKimono;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.util.ClientUtils;
import cn.mcmod.sakura.util.RecipesUtil;
import cn.mcmod.sakura.util.TagPropertyAccessor.TagPropertyInteger;
import cn.mcmod.sakura.util.TagPropertyAccessor.TagPropertyString;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKimono extends ItemArmor {
    public ItemKimono() {
        super(ItemLoader.KIMONO_MATERIAL, 0, EntityEquipmentSlot.LEGS);
        setUnlocalizedName(SakuraMain.MODID + "." + "kimono");
    }

    public static final TagPropertyString texture_name = new TagPropertyString("texture_name");
    
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
    	return ClientUtils.getKimonoModel(entityLiving, itemStack, new ModelKimono());
    }


    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	NBTTagCompound nbt = RecipesUtil.getItemTagCompound(stack);
    	String name = texture_name.get(nbt,"kimono");
    	tooltip.add(I18n.format("sakura.kimono.texture.name", new Object())+":"+name);
    	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    
    
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
    	if(this.isInCreativeTab(tab)){
    		for(int i =1;i<4;i++){
    		ItemStack stack =new ItemStack(this, 1, 0);
    		NBTTagCompound nbt = RecipesUtil.getItemTagCompound(stack);
    		texture_name.set(nbt, "kimono_"+i);
    		items.add(stack);
    		}
    	}
    	super.getSubItems(tab, items);
    }
    
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
    	NBTTagCompound nbt = RecipesUtil.getItemTagCompound(stack);
        String name = texture_name.get(nbt,"kimono");
    	return SakuraMain.MODID + ":" + "textures/models/armor/"+name+".png";
    }
}
