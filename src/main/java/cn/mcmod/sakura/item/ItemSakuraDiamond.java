package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.client.SakuraParticleType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemSakuraDiamond extends Item {

    public ItemSakuraDiamond() {
        this.setUnlocalizedName("sakura.sakura_diamond");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, false);

        if (raytraceresult != null && raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK && worldIn.getBlockState(raytraceresult.getBlockPos()).getBlock() == Blocks.END_PORTAL_FRAME) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
        }
		if (worldIn.isRemote) {
		    int j = worldIn.rand.nextInt(2) * 2 - 1;
		    int k = worldIn.rand.nextInt(2) * 2 - 1;

		    double d0 = playerIn.getPosition().getX() + 0.25D * j;
		    double d1 = playerIn.getPosition().getY() + 1D;
		    double d2 = playerIn.getPosition().getZ() + 0.25D * k;
		    double d3 = worldIn.rand.nextFloat() * j * 0.1D;
		    double d4 = (worldIn.rand.nextFloat() * 0.055D) + 0.015D;
		    double d5 = worldIn.rand.nextFloat() * k * 0.1D;

		    SakuraMain.proxy.spawnParticle(SakuraParticleType.LEAVESSAKURA, d0, d1, d2, d3, -d4, d5);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
