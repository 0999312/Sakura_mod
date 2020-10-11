package cn.mcmod.sakura.item.tool;

import java.util.Set;

import com.google.common.collect.Sets;

import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemHammer extends ItemTool {
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(BlockLoader.TATARA,BlockLoader.TATARA_SMELTING);

	public ItemHammer(ToolMaterial materialIn) {
		super(materialIn, EFFECTIVE_ON);
		this.setNoRepair();
		this.setHarvestLevel("forging_hammer", materialIn.getHarvestLevel());
	}
	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		 int dmg = itemStack.getItemDamage();
		 if (dmg < this.getMaxDamage(itemStack)) {
			 ItemStack stack = itemStack.copy();
			 stack.setItemDamage(dmg+1);
	         return stack;
	        }
		return super.getContainerItem(itemStack);
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		  int dmg = stack.getItemDamage();
		  if (dmg < this.getMaxDamage(stack)) {
	            return true;
	        }
		return super.hasContainerItem(stack);
	}
}
