package cn.mcmod.sakura.api.recipes;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

public class PotRecipes {
	public final Map<Pair<Object[], ItemStack>, List<FluidStack>> RecipesList = Maps.newHashMap();
	
	private static final PotRecipes RECIPE_BASE = new PotRecipes();
    
	public static PotRecipes getInstance() {
		return RECIPE_BASE;
	}

    public void addRecipes(ItemStack result, Object[] list, FluidStack fluidStack) {
		addRecipes(result, list, Lists.newArrayList(fluidStack));
    }
    public void addRecipes(ItemStack result, Object[] list) {
		addRecipes(result, list, RecipesUtil.getInstance().EMPTY_FLUID);
    }
    public void addRecipes(ItemStack result, Object[] list, List<FluidStack> listfluid) {
    	
    	Pair<Object[], ItemStack> items = Pair.of(list, result);
		RecipesList.put(items, listfluid);
    }

	public FluidStack getResultFluid(FluidStack fluid, List<ItemStack> inputs) {
		return getResultFluid(fluid, checkItems(inputs));
	}
	public FluidStack getResultFluid(FluidStack fluid, Pair<Object[], ItemStack> recipe) {
		if(recipe!=null)
			for(FluidStack k : RecipesList.get(recipe)) {
				if(k.isFluidEqual(fluid))
					return k;
			}
		return null;
	}

	private Pair<Object[], ItemStack> checkItems(List<ItemStack> inputs) {
		for (Entry<Pair<Object[], ItemStack>, List<FluidStack>> entry : RecipesList.entrySet()) {
            boolean flg1 = true;
            if ((inputs.size() != entry.getKey().getLeft().length)) 
                continue;
        	for (Object obj1 : entry.getKey().getLeft()) {
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
                return entry.getKey();
            }
		}
		return null;
	}
	
	public ItemStack getResultItemStack(FluidStack fluid, List<ItemStack> inputs) {
		Pair<Object[], ItemStack> recipe = checkItems(inputs);
		if(recipe!=null)
			if(getResultFluid(fluid, recipe)!=null ||RecipesList.get(recipe).isEmpty())
				return recipe.getRight();
		return ItemStack.EMPTY;
	}

	public void ClearRecipe(ItemStack itemOutput) {
		for (Entry<Pair<Object[], ItemStack>, List<FluidStack>> entry : RecipesList.entrySet()) {
			Pair<Object[], ItemStack> recipe = entry.getKey();
			if(RecipesUtil.getInstance().compareItems(itemOutput, recipe.getRight())) {
				RecipesList.remove(entry.getKey());
				return ;
			}
		}
		throw new NullPointerException("NO RECIPE HERE");
	}
	
    public void ClearAllRecipe() {
    	RecipesList.clear();
	}

}