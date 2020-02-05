package cn.mcmod.sakura.block;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class BlockStairBasic extends BlockStairs {

	protected BlockStairBasic(IBlockState modelState) {
		super(modelState);
		  this.useNeighborBrightness = true;
		    this.setCreativeTab(modelState.getBlock().getCreativeTabToDisplayOn());
	}

}
