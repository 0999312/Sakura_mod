package cn.mcmod.sakura.block;

import cn.mcmod.sakura.CommonProxy;
import cn.mcmod_mmf.mmlib.block.BlockFacing;
import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class BlockTaiko extends BlockFacing {

	public BlockTaiko() {
		super(Material.WOOD, false);
        this.setSoundType(SoundType.WOOD);
        this.setHardness(1.2F);
        this.setResistance(4.0F);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(RecipesUtil.containsMatch(false, OreDictionary.getOres("stickWood"), playerIn.getHeldItem(hand))){
			worldIn.playSound(playerIn, pos, CommonProxy.TAIKO, SoundCategory.BLOCKS, 1.2F, 1.2F);
			playerIn.swingArm(hand);
			}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
}
