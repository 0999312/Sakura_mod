package cn.mcmod.sakura.item.katana;

import cn.mcmod.sakura.SakuraMain;
import cn.mcmod.sakura.item.ItemLoader;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSheath extends Item {

    public ItemSheath() {
        this.maxStackSize = 1;
        this.setMaxDamage(ToolMaterial.WOOD.getMaxUses());
        this.setUnlocalizedName(SakuraMain.MODID + "." + "sheath");

    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BLOCK;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
        if (state.getBlockHardness(worldIn, pos) != 0.0D) {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    /**
     * Return whether this item is repairable in an anvil.
     *
     * @param toRepair the {@code ItemStack} being repaired
     * @param repair   the {@code ItemStack} being used to perform the repair
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        ItemStack mat = ToolMaterial.WOOD.getRepairItemStack();
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    public void sheath_In(EntityPlayer player) {
		ItemStack item_l = player.getHeldItemMainhand();
		ItemStack item_r = player.getHeldItemOffhand();
		if(item_r.getItem()==ItemLoader.KATANA){
			player.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1F, 1F);
			player.setHeldItem(EnumHand.MAIN_HAND, ItemLoader.KATANA_SHEATH.setBlade(item_r));
			player.setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);
		}else if(item_r.getItem()==ItemLoader.SAKURAKATANA){
			player.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1F, 1F);
			player.setHeldItem(EnumHand.MAIN_HAND, ItemLoader.SAKURAKATANA_SHEATH.setBlade(item_r));
			player.setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);
		}else if(item_l.getItem()==ItemLoader.KATANA){
			player.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1F, 1F);
			player.setHeldItem(EnumHand.OFF_HAND, ItemLoader.KATANA_SHEATH.setBlade(item_l));
			player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
		}else if(item_l.getItem()==ItemLoader.SAKURAKATANA){
			player.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1F, 1F);
			player.setHeldItem(EnumHand.OFF_HAND, ItemLoader.SAKURAKATANA_SHEATH.setBlade(item_l));
			player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.EMPTY);
		}	
	}
}