package cn.mcmod.sakura.jei;

import cn.mcmod.sakura.block.BlockLoader;
import cn.mcmod.sakura.gui.GuiCampfirePot;
import cn.mcmod.sakura.gui.GuiStoneMortar;
import cn.mcmod.sakura.inventory.ContainerCampfirePot;
import cn.mcmod.sakura.inventory.ContainerStoneMortar;
import cn.mcmod.sakura.item.ItemLoader;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEICompat implements IModPlugin {
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(PotRecipeMaker.getRecipes(jeiHelpers),"sakura.cooking_pot");
		registry.addRecipes(MortarRecipeMaker.getRecipes(jeiHelpers),"sakura.mortar");

		registry.addRecipeClickArea(GuiCampfirePot.class, 91, 41, 28, 23,"sakura.cooking_pot");
		registry.addRecipeClickArea(GuiStoneMortar.class, 77, 32, 28, 23,"sakura.mortar");

		recipeTransferRegistry.addRecipeTransferHandler(ContainerCampfirePot.class,"sakura.cooking_pot", 0, 9, 10, 36);
		recipeTransferRegistry.addRecipeTransferHandler(ContainerStoneMortar.class,"sakura.mortar", 0, 4, 6, 36);

		registry.addRecipeCatalyst(new ItemStack(ItemLoader.POT),"sakura.cooking_pot");
		registry.addRecipeCatalyst(new ItemStack(BlockLoader.STONEMORTAR),"sakura.mortar");

	}
	
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new IRecipeCategory[]{
				new CategoryPot(registry.getJeiHelpers().getGuiHelper()),
				new CategoryMortar(registry.getJeiHelpers().getGuiHelper()),
		}
	);
		
	}
	
}
