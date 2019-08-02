package cn.mcmod.sakura.item;

import cn.mcmod.sakura.SakuraMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemBase extends Item {
	protected String[] subNames;
	private Item containerItem;
	public ItemBase(String name, int stackSize, String... subNames) {
		this.setUnlocalizedName(SakuraMain.MODID+"."+name);
		this.setHasSubtypes(subNames!=null&&subNames.length > 0);
		this.setMaxStackSize(stackSize);
		this.subNames = subNames!=null&&subNames.length > 0?subNames: null;
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

	public ItemBase setContainerItem(Item containerItem) {
		this.containerItem = containerItem;
		return this;
	}

	@Override
	public boolean onEntityItemUpdate(EntityItem entityItem) {
		if (entityItem.isInWater()) {
			if (entityItem.getItem().getMetadata() == 4) {
				entityItem.getItem().setItemDamage(6);
			}
			if (entityItem.getItem().getMetadata() == 5) {
				entityItem.getItem().setItemDamage(7);
			}
		}
		return super.onEntityItemUpdate(entityItem);
	}
}
