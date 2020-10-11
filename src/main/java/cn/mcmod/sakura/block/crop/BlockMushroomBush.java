package cn.mcmod.sakura.block.crop;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import cn.mcmod.sakura.item.ItemLoader;
import cn.mcmod_mmf.mmlib.block.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockMushroomBush extends BlockBase implements IShearable {
	public static final PropertyBool isMatsutake = PropertyBool.create("is_matsutake");
	public BlockMushroomBush() {
		super(Material.LEAVES, false);
		this.setDefaultState(getDefaultState().withProperty(isMatsutake, false));
		this.setSoundType(SoundType.PLANT);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
	}
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		List<ItemStack> itemstack = Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this),1,0));
		if(world.getBlockState(pos).getValue(isMatsutake)){
			itemstack.add(new ItemStack(ItemLoader.FOODSET,1,135));
		}
		return itemstack;
	}
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		super.getDrops(drops, world, pos, state, fortune);
		drops.clear();
		if(state.getValue(isMatsutake)){
			drops.add(new ItemStack(ItemLoader.FOODSET,1,135));
		}else{
	        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
	        switch (rand.nextInt(2)) {
			case 0:
				drops.add(new ItemStack(Blocks.BROWN_MUSHROOM));
				break;
			case 1:
				drops.add(new ItemStack(ItemLoader.FOODSET,1,136));
				break;
			case 2:
				drops.add(new ItemStack(ItemLoader.FOODSET,1,137));
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(isMatsutake, (meta == 1));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(isMatsutake).booleanValue()? 1 : 0);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { isMatsutake });
	}

}
