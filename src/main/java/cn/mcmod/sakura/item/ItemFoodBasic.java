package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemFoodBasic extends ItemFood {

	protected String[] subNames;
	protected int[] amount;
	protected float[] saturation;
	public ItemFoodBasic(String name, int stackSize,int[] amounts,float[] saturations, String... subNames) {
		super(amounts[0],saturations[0], false);
		this.setUnlocalizedName(SakuraMain.MODID+"."+name);
		this.setHasSubtypes(subNames!=null&&subNames.length > 0);
		this.setMaxStackSize(stackSize);
		this.subNames = subNames!=null&&subNames.length > 0?subNames: null;
		this.amount = amounts!=null&&amounts.length > 0?amounts: null;
		this.saturation = saturations!=null&&saturations.length > 0?saturations: null;
	}
	
	@Override
	public int getHealAmount(ItemStack stack) {
		return stack.getMetadata() < getAmounts().length?getAmounts()[stack.getMetadata()]: 0;
	}

	@Override
	public float getSaturationModifier(ItemStack stack) {
		return stack.getMetadata() < getSaturations().length?getSaturations()[stack.getMetadata()]: 0;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if(this.isInCreativeTab(tab))
			if(getSubNames()!=null)
			{
				for(int i = 0; i < getSubNames().length; i++)
						list.add(new ItemStack(this, 1, i));
			}
			else
				list.add(new ItemStack(this));
	}
	public int[] getAmounts() {
		return amount;
	}
	
	public float[] getSaturations() {
		return saturation;
	}
	
	public String[] getSubNames() {
		return subNames;
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		if(getSubNames()!=null) {
			String subName = stack.getMetadata() < getSubNames().length?"item."+getSubNames()[stack.getMetadata()]: "";
			return subName;
		}
		return this.getUnlocalizedName();
	}
	
}
