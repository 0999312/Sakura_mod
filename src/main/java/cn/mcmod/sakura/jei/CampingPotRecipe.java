package cn.mcmod.sakura.jei;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IIngredientType;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class CampingPotRecipe implements IRecipeWrapper
{
	  private final List<List<ItemStack>> inputs;
	  private final List<List<FluidStack>> fluid;
	  private final ItemStack output;
	  
	  public CampingPotRecipe(List<List<ItemStack>> inputs,List<List<FluidStack>> fluid, ItemStack output)
	  {
	    this.inputs = inputs;
	    this.fluid = fluid;
	    this.output = output;
	  }
	  
	public void getIngredients(IIngredients ingredients)
	  {
	    ingredients.setInputLists(VanillaTypes.ITEM, this.inputs);
	    ingredients.setInputLists(VanillaTypes.FLUID, this.fluid);
	    ingredients.setOutput(VanillaTypes.ITEM, this.output);

	  }
	  

	}
