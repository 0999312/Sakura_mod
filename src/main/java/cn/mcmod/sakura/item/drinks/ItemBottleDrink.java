package cn.mcmod.sakura.item.drinks;

import cn.mcmod.sakura.item.ItemBase;
import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod.sakura.util.RecipesUtil;
import cn.mcmod.sakura.util.TagPropertyAccessor.TagPropertyInteger;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemBottleDrink extends ItemBase {
	public static final TagPropertyInteger amount = new TagPropertyInteger("amount");
	public ItemBottleDrink(String name, String[] subNames) {
		super(name, 1, subNames);
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return amount.get(RecipesUtil.getItemTagCompound(stack),0)>0;
	} 
	 
	 @Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return (double)amount.get(RecipesUtil.getItemTagCompound(stack),0)/4.0F;
	}
	
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
    	NBTTagCompound tag = RecipesUtil.getItemTagCompound(itemStack);
        int dmg = amount.get(tag,0);
        if (dmg < 4) {
            ItemStack stack = itemStack.copy();
            NBTTagCompound tag_result = RecipesUtil.getItemTagCompound(stack);
            amount.add(tag_result, 1);
            return stack;
        }
		return new ItemStack(ItemLoader.MATERIAL,1,47);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
            return true;
    }
}
