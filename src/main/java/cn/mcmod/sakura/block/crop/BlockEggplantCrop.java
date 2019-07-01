package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.Item;

public class BlockEggplantCrop extends BlockHighCrop {

	public BlockEggplantCrop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Item getCrop() {
		// TODO Auto-generated method stub
		return ItemLoader.EGGPLANT;
	}
	@Override
	protected Item getSeed() {
		// TODO Auto-generated method stub
		return ItemLoader.EGGPLANT_SEEDS;
	}
}
