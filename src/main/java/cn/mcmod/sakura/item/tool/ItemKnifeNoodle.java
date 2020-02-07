package cn.mcmod.sakura.item.tool;

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
        }
		return super.getContainerItem(itemStack);
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        int dmg = stack.getItemDamage();
        if (dmg < this.getMaxDamage(stack))
        {
            return true;
        }
		return super.hasContainerItem(stack);
    }
    @Override
    public float getAttackDamage() {
    	return super.getAttackDamage()+2F;
    }
}
