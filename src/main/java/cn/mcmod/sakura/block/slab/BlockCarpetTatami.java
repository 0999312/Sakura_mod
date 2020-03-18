package cn.mcmod.sakura.block.slab;

import java.util.Random;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod_mmf.mmlib.block.slab.BlockCarpetFacing;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCarpetTatami extends BlockCarpetFacing{
	public final boolean isNS;
	public BlockCarpetTatami(boolean ns) {
		super(Material.CLOTH);
		this.setTickRandomly(true);
		this.setSoundType(SoundType.PLANT);
		setHardness(0.15F).setResistance(0.5F);
		isNS = ns;
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(worldIn.canBlockSeeSky(pos)&&worldIn.isDaytime()){
				worldIn.setBlockState(pos, (isNS?BlockLoader.TATAMI_TAN_NS_CARPET:BlockLoader.TATAMI_TAN_CARPET).getDefaultState().withProperty(FACING, state.getValue(FACING)));
		}
		super.updateTick(worldIn, pos, state, rand);
	}
}
