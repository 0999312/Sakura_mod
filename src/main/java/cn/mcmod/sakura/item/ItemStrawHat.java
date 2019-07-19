package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.model.ModelStrawHat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStrawHat extends ItemArmor {
    public ItemStrawHat() {
        super(ItemLoader.STRAW_MATERIAL, 0, EntityEquipmentSlot.HEAD);
        setUnlocalizedName(SakuraMain.MODID + "." + "strawhat");
    }

    @SideOnly(Side.CLIENT)
    public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
        return new ModelStrawHat();
    }

    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return SakuraMain.MODID + ":" + "textures/models/armor/strawhat.png";
    }
}
