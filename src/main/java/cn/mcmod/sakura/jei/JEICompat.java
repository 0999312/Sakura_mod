package cn.mcmod.sakura.jei;

import cn.mcmod.sakura.gui.GuiCampfirePot;
import cn.mcmod.sakura.inventory.ContainerCampfirePot;
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

		registry.addRecipeClickArea(GuiCampfirePot.class, 91, 41, 28, 23,"sakura.cooking_pot");

		recipeTransferRegistry.addRecipeTransferHandler(ContainerCampfirePot.class,"sakura.cooking_pot", 0, 9, 10, 36);

		registry.addRecipeCatalyst(new ItemStack(ItemLoader.POT),"sakura.cooking_pot");

	}
	
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new IRecipeCategory[]{
				new CategoryPot(registry.getJeiHelpers().getGuiHelper()),
//				new CategoryIcecreamMaking(registry.getJeiHelpers().getGuiHelper()),
//				new CategoryRoller(registry.getJeiHelpers().getGuiHelper()),
//				new CategoryOven(registry.getJeiHelpers().getGuiHelper())
		}
	);
		
	}
	
}
