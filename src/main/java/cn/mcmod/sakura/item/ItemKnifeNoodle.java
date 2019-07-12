package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemKnifeNoodle extends ItemSword {

	public ItemKnifeNoodle() {
		super(ToolMaterial.IRON);
		this.setUnlocalizedName(SakuraMain.MODID+"."+"knife_noodle");
		this.setMaxDamage(ToolMaterial.DIAMOND.getMaxUses());
	}
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        int dmg = itemStack.getItemDamage();
        if (dmg < this.getMaxDamage(itemStack))
        {
            ItemStack stack = itemStack.copy();
            stack.setItemDamage(dmg +1);
            return stack;
        }else
            return super.getContainerItem(itemStack);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        int dmg = stack.getItemDamage();
        if (dmg < this.getMaxDamage(stack))
        {
            return true;
        }
        else
        {
            return super.hasContainerItem(stack);
        }
    }
    @Override
    public float getAttackDamage() {
    	return super.getAttackDamage()+2F;
    }
}
