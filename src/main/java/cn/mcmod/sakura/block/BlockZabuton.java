package cn.mcmod.sakura.block;

import cn.mcmod_mmf.mmlib.block.BlockBase;
import cn.mcmod_mmf.mmlib.util.SeatUtil;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockZabuton extends BlockBase {
	public BlockZabuton() {
		super(Material.CLOTH, false);
		this.setSoundType(SoundType.CLOTH);
		this.setHardness(0.2f);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return SeatUtil.getInstance().sitOnBlock(worldIn, pos.getX(), pos.getY()+0.1f, pos.getZ(), playerIn, 0D);
	}
}
