package cn.mcmod.sakura.jei;

import java.awt.Color;
import java.util.Collections;
import java.util.List;

import cn.mcmod.sakura.tileentity.TileEntityStoneMortar.MortarRecipes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class MortarRecipe  implements IRecipeWrapper
{
	  private final List<List<ItemStack>> inputs;
	  private final List<List<ItemStack>> output;
	  
	  public MortarRecipe(List<List<ItemStack>> inputs, List<List<ItemStack>> output)
	  {
	    this.inputs = inputs;
	    this.output = output;
	  }
	  
	public void getIngredients(IIngredients ingredients)
	  {
		    ingredients.setInputLists(VanillaTypes.ITEM, this.inputs);
		    ingredients.setOutputLists(VanillaTypes.ITEM, this.output);
	  }
	  
	  public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
	  {
	    MortarRecipes furnaceRecipes = MortarRecipes.instance();
	  }
	}
