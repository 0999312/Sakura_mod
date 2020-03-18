package cn.mcmod.sakura.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.util.RecipesUtil;

public class BarrelRecipes {
	public static final Map<FluidStack, Map<Object[], FluidStack>> RecipesList = Maps.newHashMap();
	private static final BarrelRecipes RECIPE_BASE = new BarrelRecipes();
    
	public static BarrelRecipes getInstance() {
		return RECIPE_BASE;
	}
    public void register(FluidStack input, FluidStack output) {
    	register(input,output, new Object[]{ItemStack.EMPTY,ItemStack.EMPTY,ItemStack.EMPTY});
    }
    public void register(FluidStack input, FluidStack output, Object[] additives) {
    	Map<Object[], FluidStack> items = null;
		if (!RecipesList.containsKey(input)) {
			items = Maps.newHashMap();
			RecipesList.put(input, items);
		} else {
			items = RecipesList.get(input);
		}
		items.put(additives, output);
    }

	public FluidStack getFluidStack(FluidStack fluid) {
		for (FluidStack entry : RecipesList.keySet()) {
			if(entry.isFluidEqual(fluid))
				return entry;
		}
		return null;
	}

	public FluidStack getResultFluidStack(FluidStack fluid, ItemStack[] inputs) {
		for (Entry<FluidStack, Map<Object[], FluidStack>> entry : RecipesList.entrySet()) {
			if(entry.getKey().isFluidEqual(fluid))
		        for(Entry<Object[], FluidStack> entry2 : entry.getValue().entrySet()){
		            boolean flg1 = true;
	            	for (Object obj1 : entry2.getKey()) {
		        		boolean flg2 = false;
		        		for (ItemStack input:inputs) {
		                	if(obj1 instanceof ItemStack){
		                		ItemStack stack1 = (ItemStack) obj1;
		    	                if (ItemStack.areItemsEqual(stack1, input)) {
		    	                    flg2 = true;
		    	                    break;
		    	                }
		                    }else if(obj1 instanceof String){
		                    	NonNullList<ItemStack> ore = OreDictionary.getOres((String) obj1);
		                    	if (!ore.isEmpty()&&RecipesUtil.containsMatch(false, ore, input)) {
		                            flg2 = true;
		    	                    break;
		                        }
		                    }
		                }
		                if (!flg2) {
		                    flg1 = false;
		                    break;
		                }
		            }

		            if (flg1) {
		                return entry2.getValue();
		            }
		        }
		}

		return null;
	}
  
    public static void ClearRecipe(FluidStack input) {
    	RecipesList.remove(input);
	}
    
    public static void ClearAllRecipe() {
    	RecipesList.clear();
	}
}
