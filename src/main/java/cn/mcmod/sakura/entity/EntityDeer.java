package cn.mcmod.sakura.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import cn.mcmod.sakura.SakuraMain;

public class EntityDeer extends EntityAnimal {

	public EntityDeer(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 0.95F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.WHEAT, true));
		this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 7.0F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityAnimal.class, 6.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	@Override
	public float getEyeHeight() {
		return this.height * 0.98F;
	}

	@Nullable
	@Override
	public EntityDeer createChild(EntityAgeable ageable) {
		EntityDeer entityDeer = new EntityDeer(this.world);
		return entityDeer;
	}

	@Override
	protected ResourceLocation getLootTable() {
		// TODO Auto-generated method stub
		return new ResourceLocation(SakuraMain.MODID, "entity/deer");
	}
}
