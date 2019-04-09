package cn.mcmod.sakura.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemFoodContain extends ItemFoodBasic {
	public ItemStack[] foodcontainer;
	public ItemFoodContain(String name, int stackSize, int[] amounts, float[] saturations, String[] subNames,ItemStack[] container) {
		super(name, stackSize, amounts, saturations, subNames);
		foodcontainer= container;
	}

	public ItemStack getFoodContainerItem(ItemStack stack) {
		return stack.getMetadata() < getContainers().length?getContainers()[stack.getMetadata()]: null;
	}

	public ItemStack[] getContainers() {
		return foodcontainer;
	}

	@Override
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));

            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
            }
        }
        return getFoodContainerItem(stack);
    }
}
