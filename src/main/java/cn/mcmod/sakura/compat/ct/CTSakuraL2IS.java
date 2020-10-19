package cn.mcmod.sakura.compat.ct;

import cn.mcmod.sakura.api.recipes.LiquidToItemRecipe;
import cn.mcmod.sakura.util.SakuraRecipeRegister;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;


@ZenClass("mods.sakura.liquid_to_itemStack")
@ZenRegister
public class CTSakuraL2IS {
	@ZenMethod
	public static void RemoveRecipe(ILiquidStack input_fluid,IIngredient input) {
		Object itemInput=null;
		if (input instanceof IItemStack) {
			itemInput=CraftTweakerMC.getItemStack(input);
		} 
		else if(input instanceof IOreDictEntry) {
			itemInput=((IOreDictEntry)input).getName();
		}
		if(itemInput!=null)
			SakuraRecipeRegister.getInstance().actions.add(new Removal(CraftTweakerMC.getLiquidStack(input_fluid),itemInput));
	}
	@ZenMethod
	public static void AddRecipe(IItemStack input,IItemStack output,ILiquidStack input_fluid) {
		SakuraRecipeRegister.getInstance().actions.add(new Addition(CraftTweakerMC.getItemStack(input), CraftTweakerMC.getItemStack(output),CraftTweakerMC.getLiquidStack(input_fluid)));
	}
	
	@ZenMethod
	public static void ClearAllRecipe() {
		SakuraRecipeRegister.getInstance().actions.add(new ClearAllRecipe());
	}
	
    private static final class Removal implements IAction
    {
        private final Object itemInput;
        private final FluidStack fluid;
        private Removal(FluidStack fluid,Object itemInput)
        {
        	this.fluid = fluid;
            this.itemInput = itemInput;
        }

        @Override
        public void apply()
        {
        	LiquidToItemRecipe.instance().ClearRecipe(fluid,itemInput);
        }

        @Override
        public String describe()
        {
            return "Removing a recipe for Liquid To Item";
        }
    }
	
    private static final class Addition implements IAction
    {
        private final ItemStack itemInput;
        private final ItemStack itemOutput;
        private final FluidStack fluidInput;
        
        private Addition(ItemStack itemInput, ItemStack itemOutput,FluidStack fluidInput)
        {
            this.itemInput = itemInput;
            this.itemOutput = itemOutput;
            this.fluidInput = fluidInput;
        }

        @Override
        public void apply()
        {
        	LiquidToItemRecipe.instance().addRecipes(itemInput, itemOutput, fluidInput);
        }

        @Override
        public String describe()
        {
            return "Adding a recipe for Liquid To Item";
        }
    }

	
	private static final class ClearAllRecipe implements IAction
    {
        @Override
        public void apply()
        {
        	LiquidToItemRecipe.instance().ClearAllRecipe();
        }

        @Override
        public String describe()
        {
            return "Removing all recipes from Liquid To Item";
        }
    }
}
