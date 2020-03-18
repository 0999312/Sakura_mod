package cn.mcmod.sakura.api.recipes;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import cn.mcmod_mmf.mmlib.util.RecipesUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class MortarRecipes {

    public static final Map<Object[], ItemStack[]> RecipesList = Maps.newHashMap();

	private static final MortarRecipes RECIPE_BASE = new MortarRecipes();
    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static MortarRecipes instance() {
        return RECIPE_BASE;
    }

    public void addMortarRecipes(ItemStack[] result, Object[] main) {
        RecipesList.put(main, result);
    }

    public ItemStack[] getResult(List<ItemStack> inputs) {
        ItemStack[] retStack = new ItemStack[0];

        for(Entry<Object[], ItemStack[]> entry : RecipesList.entrySet()){
            boolean flg1 = true;
            if ((inputs.size() != entry.getKey().length)) 
                continue;
        	for (Object obj1 : entry.getKey()) {
        		boolean flg2 = false;
        		for (ItemStack input:inputs) {
        			if(input.isEmpty()) break;
                	if(obj1 instanceof ItemStack){
                		ItemStack stack1 = (ItemStack) obj1;
    	                if (ItemStack.areItemsEqual(stack1, input)) {
    	                	inputs.remove(input);
    	                    flg2 = true;
    	                    break;
    	                }
                    }else if(obj1 instanceof String){
                    	NonNullList<ItemStack> ore = OreDictionary.getOres((String) obj1);
                    	if (!ore.isEmpty()&&RecipesUtil.containsMatch(false, ore, input)) {
    	                	inputs.remove(input);
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
                return entry.getValue();
            }
        }
        
        return retStack;
    }

    public void ClearRecipe(Object[] inputs) {
    	RecipesList.remove(inputs);
	}
	
    public void ClearAllRecipe() {
    	RecipesList.clear();
	}
}
