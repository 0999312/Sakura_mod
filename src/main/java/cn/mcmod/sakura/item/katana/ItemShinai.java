package cn.mcmod.sakura.item.katana;

import cn.mcmod.sakura.SakuraMain;
import com.google.common.collect.Multimap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemShinai extends ItemSword {
    private final float attackDamage;

    public ItemShinai(String name) {
    	super(ToolMaterial.WOOD);
        this.setUnlocalizedName(SakuraMain.MODID + "." + name);
        this.attackDamage = 2.0F + ToolMaterial.WOOD.getAttackDamage();
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        int i = this.getMaxItemUseDuration(stack) - timeLeft;
        if (i < 0) return;
            entityLiving.swingArm(entityLiving.getActiveHand());

            float f = (float) entityLiving.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
            f += EnchantmentHelper.getModifierForCreature(stack, entityLiving.getCreatureAttribute()) / 1.2F;

            float f1 = i / 15F;
            f1 = (f1 * f1 + f1 * 2.0F) / 2F;
            if(f1>8F) f1=8f;
            float f3 = f1 + EnchantmentHelper.getSweepingDamageRatio(entityLiving) * f ;

            float sweepingRatio = EnchantmentHelper.getSweepingDamageRatio(entityLiving);

            for (Entity entitylivingbase : worldIn.getEntitiesWithinAABB(Entity.class, entityLiving.getEntityBoundingBox().grow(1.6D + sweepingRatio * 1.2D, 0.5D + sweepingRatio * 0.15D, 1.6D + sweepingRatio * 1.2D))) {
                if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                    if (entitylivingbase instanceof EntityLivingBase) {
                    	f1 = f1/10;
                        ((EntityLivingBase) entitylivingbase).knockBack(entityLiving, 0.4F + 0.6F * f1 * EnchantmentHelper.getSweepingDamageRatio(entityLiving), MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
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
            stack.damageItem(2, entityLiving);
            ((EntityPlayer) entityLiving).getCooldownTracker().setCooldown(this, 25);

    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment.type == EnumEnchantmentType.WEAPON) {
            return true;
        }

        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }
    
    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    	super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    	if(worldIn.isRemote) return;
    	if(entityIn instanceof EntityPlayer){
    		EntityPlayer player = (EntityPlayer) entityIn;
    		ItemStack mainhand =player.getHeldItem(EnumHand.MAIN_HAND);
    		ItemStack offhand =player.getHeldItem(EnumHand.OFF_HAND);
    		boolean flag1 =!(mainhand.isEmpty())&&!(offhand.isEmpty()),
    				flag2 = mainhand.getItem() instanceof ItemShinai||offhand.getItem() instanceof ItemShinai;
    		if(flag1&&flag2) {
                player.setItemStackToSlot((mainhand.getItem() instanceof ItemShinai)?EntityEquipmentSlot.OFFHAND:EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
                if(mainhand.getItem() instanceof ItemShinai) {
                	if (!player.inventory.addItemStackToInventory(offhand)) {
                		player.dropItem(offhand, false);
                	}
                }else if (!player.inventory.addItemStackToInventory(mainhand)) {
            		player.dropItem(mainhand, false);
            	}
                player.sendStatusMessage(new TextComponentTranslation("sakura.katana.wrong_duel_shinai", new Object()), false);
    		}
    	}
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.2000000953674316D, 0));
        }
        return multimap;
    }
}