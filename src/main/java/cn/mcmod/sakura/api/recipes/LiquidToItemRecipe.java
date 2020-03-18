package cn.mcmod.sakura.api.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class LiquidToItemRecipe {
	public static final Map<FluidStack, Map<Object, ItemStack>> RecipesList = Maps.newHashMap();
	private static final LiquidToItemRecipe RECIPE_BASE = new LiquidToItemRecipe();
    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static LiquidToItemRecipe instance() {
        return RECIPE_BASE;
    }
    
	public void addRecipes(Object main, ItemStack result, FluidStack fluidStack) {
		Map<Object, ItemStack> items = null;
		if (!RecipesList.containsKey(fluidStack)) {
			items = Maps.newHashMap();
			RecipesList.put(fluidStack, items);
		} else {
			items = RecipesList.get(fluidStack);
		}
		items.put(main, result);
	}

	public ItemStack getResultItemStack(FluidStack fluid, ItemStack stack) {
		for (Entry<FluidStack, Map<Object, ItemStack>> entry : RecipesList.entrySet()) {
			if(entry.getKey().isFluidEqual(fluid))
			for (Entry<Object, ItemStack> entry2 : entry.getValue().entrySet()) {
				if (entry2.getKey() instanceof ItemStack) {
					if (ItemStack.areItemsEqual(stack, (ItemStack) entry2.getKey())) {
						return entry2.getValue();
					}
				} else if (entry2.getKey() instanceof String) {
					String dict = (String) entry2.getKey();
					NonNullList<ItemStack> ore = OreDictionary.getOres(dict);
					if (!ore.isEmpty() && RecipesUtil.containsMatch(true, ore, stack))
						return entry2.getValue();
				}
			}
		}

		return ItemStack.EMPTY;
	}
	
	public FluidStack getResultFluid(FluidStack fluid) {
		for (FluidStack entry : RecipesList.keySet()) {
			if(entry.isFluidEqual(fluid))
				return entry;
		}
		return null;
	}

	public void ClearRecipe(FluidStack fluid, Object input) {
		RecipesList.get(fluid).remove(input);
	}

	public void ClearAllRecipe() {
		RecipesList.clear();
	}
}