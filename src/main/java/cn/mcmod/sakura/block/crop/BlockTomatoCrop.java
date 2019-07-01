package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.item.Item;

public class BlockTomatoCrop extends BlockHighCrop {

	public BlockTomatoCrop() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected Item getCrop() {
		// TODO Auto-generated method stub
		return ItemLoader.TOMATO;
	}
	@Override
	protected Item getSeed() {
		// TODO Auto-generated method stub
		return ItemLoader.TOMATO_SEEDS;
	}
}
