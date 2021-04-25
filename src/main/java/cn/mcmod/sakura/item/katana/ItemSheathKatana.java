package cn.mcmod.sakura.item.katana;

import cn.mcmod.sakura.item.ItemLoader;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Map;

public class ItemSheathKatana extends Item {
	private final Item katana;
    public ItemSheathKatana(Item blade) {
    	katana=blade;
        this.maxStackSize = 1;
        this.setMaxDamage(blade.getMaxDamage());
        this.setUnlocalizedName(blade.getUnlocalizedName().substring(5)+"_sheath");
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
    	EnumHand hand = entityLiving.getActiveHand();
            //big sweep!!!
            entityLiving.swingArm(hand);

            float f = (float) entityLiving.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
            f += EnchantmentHelper.getModifierForCreature(stack, entityLiving.getCreatureAttribute()) / 1.2F;

            float f3 = 4.0F + EnchantmentHelper.getSweepingDamageRatio(entityLiving) * f;

            float sweepingRatio = 1f+EnchantmentHelper.getSweepingDamageRatio(entityLiving);

            for (Entity entitylivingbase : worldIn.getEntitiesWithinAABB(Entity.class, entityLiving.getEntityBoundingBox().grow(1.4D + sweepingRatio * 1.2D, 0.3D + sweepingRatio * 0.15D, 1.4D + sweepingRatio * 1.2D))) {
                if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                    if (entitylivingbase instanceof EntityLivingBase) {
                        if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer) entitylivingbase).isActiveItemStackBlocking()) {
                            //disable shield
                            ((EntityPlayer) entitylivingbase).disableShield(false);
                        }
                        ((EntityLivingBase) entitylivingbase).knockBack(entityLiving, 0.4F + 0.4F * EnchantmentHelper.getSweepingDamageRatio(entityLiving), MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                        entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) entityLiving), f3);
                    }

                    if (entitylivingbase instanceof MultiPartEntityPart) {
                        entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) entityLiving), f3);
                    }
                }
            }

            worldIn.playSound(null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);

            if (worldIn instanceof WorldServer) {
                double d0 = (-MathHelper.sin(entityLiving.rotationYaw * 0.017453292F));
                double d1 = MathHelper.cos(entityLiving.rotationYaw * 0.017453292F);
                ((WorldServer) worldIn).spawnParticle(EnumParticleTypes.SWEEP_ATTACK, entityLiving.posX + d0, entityLiving.posY + entityLiving.height * 0.5D, entityLiving.posZ + d1, 0, d0, 0.0D, d1, 0.0D);
            }
            dropHand(entityLiving, hand, setKatana(stack));
            ((EntityPlayer) entityLiving).getCooldownTracker().setCooldown(katana, 15);
    }
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    private void dropHand(Entity entityIn,EnumHand hand,ItemStack blade) {
    	if(entityIn instanceof EntityPlayer){
    		EntityPlayer player = (EntityPlayer) entityIn;
    		blade.damageItem(2, player);
	        if(hand == EnumHand.MAIN_HAND){
	    		ItemStack offhand =player.getHeldItem(EnumHand.OFF_HAND);
	    		boolean flag1 =!(offhand.isEmpty());
	    		if(flag1) {
	    			if (!player.inventory.addItemStackToInventory(offhand)) {
	    				player.dropItem(offhand, false);
	                }
	                player.sendStatusMessage(new TextComponentTranslation("sakura.katana.sheath.not_empty_hand", new Object()), false);
	    		}
	    		player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, blade);
	    		player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ItemLoader.SHEATH));
	        }else if(hand == EnumHand.OFF_HAND){
				ItemStack mainhand =player.getHeldItem(EnumHand.MAIN_HAND);
				boolean flag1 =!(mainhand.isEmpty());
	    		if(flag1) {
	    			if (!player.inventory.addItemStackToInventory(mainhand)) {
	    				player.dropItem(mainhand, false);
	                }
	                player.sendStatusMessage(new TextComponentTranslation("sakura.katana.sheath.not_empty_hand", new Object()), false);
	    		}
	    		player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, blade);
	    		player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(ItemLoader.SHEATH));	
	        	}
	        }
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

    public ItemStack setBlade(ItemStack blade) {
    	ItemStack result = new ItemStack(this,1);
    	result.setItemDamage(blade.getItemDamage());
    	if(blade.isItemEnchanted()){
    		Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(blade);
    		for(Enchantment ench : map.keySet()){
    			result.addEnchantment(ench, map.get(ench));
    		}
    	}
		return result;
	}
    public ItemStack setKatana(ItemStack blade) {
    	ItemStack result = new ItemStack(katana,1);
    	result.setItemDamage(blade.getItemDamage());
    	if(blade.isItemEnchanted()){
    		Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(blade);
    		for(Enchantment ench : map.keySet()){
    			result.addEnchantment(ench, map.get(ench));
    		}
    	}
		return result;
	}
}