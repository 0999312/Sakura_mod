package cn.mcmod.sakura.api.recipes;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class PotRecipes {
	public final Map<FluidStack, Map<Object[], ItemStack>> RecipesList = Maps.newHashMap();
	private static final PotRecipes RECIPE_BASE = new PotRecipes();
    
	public static PotRecipes getInstance() {
		return RECIPE_BASE;
	}
	
    public void addRecipes(ItemStack result, Object[] list, FluidStack fluidStack) {
		Map<Object[], ItemStack> items = null;
		if (!RecipesList.containsKey(fluidStack)) {
			items = Maps.newHashMap();
			RecipesList.put(fluidStack, items);
		} else {
			items = RecipesList.get(fluidStack);
		}
		items.put(list, result);
    }

	public FluidStack getResultFluid(FluidStack fluid) {
		for (FluidStack entry : RecipesList.keySet()) {
			if(entry.isFluidEqual(fluid))
				return entry;
		}
		return null;
	}

	public ItemStack getResultItemStack(FluidStack fluid, List<ItemStack> inputs) {
		for (Entry<FluidStack, Map<Object[], ItemStack>> entry : RecipesList.entrySet()) {
			if(entry.getKey().isFluidEqual(fluid))
		        for(Entry<Object[], ItemStack> entry2 : entry.getValue().entrySet()){
		            boolean flg1 = true;
		            if ((inputs.size() != entry2.getKey().length)) 
		                continue;
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
		                    	if (!ore.isEmpty()&&RecipesUtil.getInstance().containsMatch(false, ore, input)) {
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

		return ItemStack.EMPTY;
	}

    public void ClearRecipe(FluidStack fluid,Object[] input) {
    	RecipesList.get(fluid).remove(input);
	}
	
    public void ClearAllRecipe() {
    	RecipesList.clear();
	}

}