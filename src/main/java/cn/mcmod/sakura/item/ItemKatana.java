package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class ItemKatana extends Item {
    private final float attackDamage;
    private final Item.ToolMaterial material;

    public ItemKatana(Item.ToolMaterial material, String name) {
        this.material = material;
        this.maxStackSize = 1;
        this.setMaxDamage(material.getMaxUses());
        this.setUnlocalizedName(SakuraMain.MODID + "." + name);
        this.attackDamage = 2.0F + material.getAttackDamage();
        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING, stack);

        playerIn.setActiveHand(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);

    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING, stack);

        if (k > 0) {
            //big sweep!!!
            entityLiving.swingArm(entityLiving.getActiveHand());

            float f = (float) entityLiving.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
            f += EnchantmentHelper.getModifierForCreature(stack, entityLiving.getCreatureAttribute()) / 1.2F;

            float f3 = 2.0F + EnchantmentHelper.getSweepingDamageRatio(entityLiving) * f;

            float sweepingRatio = EnchantmentHelper.getSweepingDamageRatio(entityLiving);

            for (Entity entitylivingbase : worldIn.getEntitiesWithinAABB(Entity.class, entityLiving.getEntityBoundingBox().grow(1.4D + sweepingRatio * 1.2D, 0.3D + sweepingRatio * 0.15D, 1.4D + sweepingRatio * 1.2D))) {
                if (entitylivingbase != entityLiving && !entityLiving.isOnSameTeam(entitylivingbase)) {
                    if (entitylivingbase instanceof EntityLivingBase) {
                        if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer) entitylivingbase).isActiveItemStackBlocking()) {
                            //disable shield
                            ((EntityPlayer) entitylivingbase).disableShield(false);
                        }
                        ((EntityLivingBase) entitylivingbase).knockBack(entityLiving, 0.4F + 0.4F * EnchantmentHelper.getSweepingDamageRatio(entityLiving), (double) MathHelper.sin(entityLiving.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(entityLiving.rotationYaw * 0.017453292F)));
                    }
                    entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) entityLiving), f3);
                }
            }

            worldIn.playSound(null, entityLiving.posX, entityLiving.posY, entityLiving.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entityLiving.getSoundCategory(), 1.0F, 1.0F);

            if (worldIn instanceof WorldServer) {
                double d0 = (double) (-MathHelper.sin(entityLiving.rotationYaw * 0.017453292F));
                double d1 = (double) MathHelper.cos(entityLiving.rotationYaw * 0.017453292F);
                ((WorldServer) worldIn).spawnParticle(EnumParticleTypes.SWEEP_ATTACK, entityLiving.posX + d0, entityLiving.posY + (double) entityLiving.height * 0.5D, entityLiving.posZ + d1, 0, d0, 0.0D, d1, 0.0D);
            }

            stack.damageItem(2, entityLiving);

            ((EntityPlayer) entityLiving).getCooldownTracker().setCooldown(this, 25);
        }

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
        return EnumAction.BLOCK;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    /**
     * Returns the amount of damage this item will deal. One heart of damage is equal to 2 damage points.
     */
    public float getAttackDamage() {
        return this.material.getAttackDamage();
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Block block = state.getBlock();

        if (block == Blocks.WEB) {
            return 15.0F;
        } else {
            Material material = state.getMaterial();
            return material != Material.PLANTS && material != Material.VINE && material != Material.CORAL && material != Material.LEAVES && material != Material.GOURD ? 1.0F : 1.5F;
        }
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
        if ((double) state.getBlockHardness(worldIn, pos) != 0.0D) {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(IBlockState blockIn) {
        return blockIn.getBlock() == Blocks.WEB;
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability() {
        return this.material.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName() {
        return this.material.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     *
     * @param toRepair the {@code ItemStack} being repaired
     * @param repair   the {@code ItemStack} being used to perform the repair
     */
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        ItemStack mat = this.material.getRepairItemStack();
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.2000000953674316D, 0));
        }

        return multimap;
    }
}