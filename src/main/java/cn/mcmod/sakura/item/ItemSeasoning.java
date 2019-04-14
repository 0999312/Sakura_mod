package cn.mcmod.sakura.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSeasoning extends Item {
    public ItemSeasoning(String name, int damage) {
        setUnlocalizedName(name);
        setMaxDamage(damage);
        setMaxStackSize(1);
        setContainerItem(Items.GLASS_BOTTLE);
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

}
