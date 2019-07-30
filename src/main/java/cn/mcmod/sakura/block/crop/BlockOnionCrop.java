package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.Item;

public class BlockOnionCrop extends BlockHighCrop {

	public BlockOnionCrop() {
		super();
	}
	@Override
	protected Item getCrop() {
		return ItemLoader.ONION;
	}
	@Override
	protected Item getSeed() {
		return ItemLoader.ONION_SEEDS;
	}
}
