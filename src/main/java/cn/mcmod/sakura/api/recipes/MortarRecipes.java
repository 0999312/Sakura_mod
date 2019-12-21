package cn.mcmod.sakura.api.recipes;

import java.util.ArrayList;
import java.util.Iterator;

import cn.mcmod.sakura.util.RecipesUtil;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class MortarRecipes {
    public ItemStack[] resultItems = new ItemStack[]{};
    public ArrayList<Object> inputItems = new ArrayList<Object>();
    public boolean enchantment = false;
    public static ArrayList<MortarRecipes> mortarRecipesList = new ArrayList<MortarRecipes>();


    public MortarRecipes() {
    }

    public MortarRecipes(ItemStack[] result, Object[] main) {
        this.setMortarRecipes(result, main);
    }

    public void setMortarRecipes(ItemStack[] result, Object[] main) {
        this.clear();
    	for (Object o : main) {
			if(o instanceof ItemStack||o instanceof String){
				inputItems.add(o);
			}
			else throw new IllegalArgumentException("Not a itemStack or Ore Dictionary");
        }
        resultItems = result.clone();
    }

    /**
     * 初期化
     */
    public void clear() {
        resultItems = new ItemStack[]{};
        inputItems = new ArrayList<Object>();
    }

    public ItemStack[] getResultItemStack() {
        return resultItems.clone();
    }


    public ItemStack[] getResult(IInventory inventory) {
        ItemStack[] retStack = new ItemStack[]{};

        ArrayList<ItemStack> inventoryList = new ArrayList<ItemStack>();
        for (int i = 0; i < 4; i++) {
            if (!inventory.getStackInSlot(i).isEmpty()) {
                inventoryList.add(inventory.getStackInSlot(i).copy());
            }
        }

        if (!inputItems.isEmpty() && !inventoryList.isEmpty() && inventoryList.size() != inputItems.size()) {
            return retStack;
        }
        
        boolean flg1 = true;
        for (Object obj1 : inputItems) {
            boolean flg2 = false;
            for (int i = 0; i < inventoryList.size(); i++) {
            	if(obj1 instanceof ItemStack){
            		ItemStack stack1 = (ItemStack) obj1;
	                if (ItemStack.areItemsEqual(stack1, inventoryList.get(i))) {
	                    inventoryList.remove(obj1);
	                    flg2 = true;
	                    break;
	                }
                }else if(obj1 instanceof String){
                	NonNullList<ItemStack> ore = OreDictionary.getOres((String) obj1);
                	if (!ore.isEmpty()&&RecipesUtil.containsMatch(false, ore, inventoryList.get(i))) {
                        inventoryList.remove(obj1);
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

        if (!flg1) {
            return retStack;
        }
        
        return resultItems.clone();
    }

    public static void addRecipe(MortarRecipes recipes) {
        mortarRecipesList.add(recipes);
    }

    public static void ClearRecipe(Object[] inputs) {
		Iterator<MortarRecipes> iter = mortarRecipesList.iterator();
		while(iter.hasNext()){
			MortarRecipes recipe = iter.next();
			if(check(inputs[0], recipe.resultItems[0])
			&&check(inputs[1], recipe.resultItems[1]))
				iter.remove();
		}
	}
	
    private static boolean check(Object a,ItemStack b) {
    	if(a instanceof ItemStack||a instanceof String){
			if(a instanceof ItemStack&&ItemStack.areItemStacksEqual((ItemStack)a, b)) 
				return true;
			if(a instanceof String) {
				NonNullList<ItemStack> ore = OreDictionary.getOres((String) a);
				if(RecipesUtil.containsMatch(false, ore, b))
				return true;
			}
		}
		else throw new IllegalArgumentException("Not a itemStack or Ore Dictionary");
		return false;
	}
    
    public static void ClearAllRecipe() {
    	mortarRecipesList.clear();
	}
}
