package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.Item;

public class BlockEggplantCrop extends BlockHighCrop {

	public BlockEggplantCrop() {
		super();
	}
	@Override
	protected Item getCrop() {
		return ItemLoader.EGGPLANT;
	}
	@Override
	protected Item getSeed() {
		return ItemLoader.EGGPLANT_SEEDS;
	}
}
