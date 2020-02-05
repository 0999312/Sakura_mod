package cn.mcmod.sakura.block.crop;

import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class BlockFallenLeavesMushroom extends BlockCrops {
	public static enum EnumMushroom{
		brown_mushroom("brown_mushroom",new ItemStack(Blocks.BROWN_MUSHROOM)),
		red_mushroom("red_mushroom",new ItemStack(Blocks.RED_MUSHROOM)),
		shiitake("shiitake",new ItemStack(Blocks.RED_MUSHROOM)),
		white_mushroom("white_mushroom",new ItemStack(Blocks.RED_MUSHROOM)),
		shimeji("shimeji",new ItemStack(Blocks.RED_MUSHROOM));
		private String unlocalizedName;
		private ItemStack item_result;
		private EnumMushroom(String name,ItemStack item){
			setUnlocalizedName(name);
			setResult(item);
		}
		public String getUnlocalizedName() {
			return unlocalizedName;
		}
		public void setUnlocalizedName(String unlocalizedName) {
			this.unlocalizedName = unlocalizedName;
		}
		public ItemStack getResult() {
			return item_result;
		}
		public void setResult(ItemStack item_result) {
			this.item_result = item_result;
		}
	}
}
