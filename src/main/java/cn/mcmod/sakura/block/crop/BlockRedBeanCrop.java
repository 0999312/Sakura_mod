package cn.mcmod.sakura.block.crop;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockRedBeanCrop extends BlockCrops {

	@Override
	protected Item getCrop() {
		return ItemLoader.RED_BEAN;
	}
	@Override
	protected Item getSeed() {
		return ItemLoader.RED_BEAN;
	}
}
