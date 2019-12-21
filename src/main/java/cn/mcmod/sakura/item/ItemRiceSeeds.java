package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.block.BlockLoader;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemRiceSeeds extends Item implements IPlantable {
    public ItemRiceSeeds() {
        this.setUnlocalizedName(SakuraMain.MODID + "." + "rice_seeds");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

        if (raytraceresult == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        }
		if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
		    BlockPos blockpos = raytraceresult.getBlockPos();

		    if (!worldIn.isBlockModifiable(playerIn, blockpos) || !playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack)) {
		        return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		    }

		    BlockPos blockpos1 = blockpos.up();
		    IBlockState iblockstate = worldIn.getBlockState(blockpos);

		    if (iblockstate.getMaterial() == Material.WATER && iblockstate.getValue(BlockLiquid.LEVEL).intValue() == 0 && worldIn.isAirBlock(blockpos1)) {
		        // special case for handling block placement with water lilies
		        net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(worldIn, blockpos1);
		        worldIn.setBlockState(blockpos1, BlockLoader.RICECROP.getDefaultState());
		        if (net.minecraftforge.event.ForgeEventFactory.onPlayerBlockPlace(playerIn, blocksnapshot, net.minecraft.util.EnumFacing.UP, handIn).isCanceled()) {
		            blocksnapshot.restore(true, false);
		            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		        }

		        worldIn.setBlockState(blockpos1, BlockLoader.RICECROP.getDefaultState(), 11);

		        if (playerIn instanceof EntityPlayerMP) {
		            CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) playerIn, blockpos1, itemstack);
		        }

		        if (!playerIn.capabilities.isCreativeMode) {
		            itemstack.shrink(1);
		        }

		        playerIn.addStat(StatList.getObjectUseStats(this));
		        worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
		        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		    }
		}

		return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
    }


    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return BlockLoader.RICECROP.getDefaultState();
    }

}