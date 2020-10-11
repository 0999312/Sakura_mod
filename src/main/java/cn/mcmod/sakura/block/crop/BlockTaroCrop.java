package cn.mcmod.sakura.block.crop;

import java.util.Random;

import cn.mcmod.sakura.item.ItemLoader;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTaroCrop extends BlockCrops {

	@Override
	protected Item getCrop() {
		return ItemLoader.TARO;
	}
	@Override
	protected Item getSeed() {
		return ItemLoader.TARO;
	}
    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        super.getDrops(drops, world, pos, state, 0);
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (age >= getMaxAge()) {
            int k = 3 + fortune;

            for (int i = 0; i < k; ++i)
            {
                if (rand.nextInt(2 * getMaxAge()) <= age){
                    drops.add(new ItemStack(this.getSeed(), 1, 0));
                    drops.add(new ItemStack(ItemLoader.MATERIAL,1,63));
                }
            }
        }
    }

}
